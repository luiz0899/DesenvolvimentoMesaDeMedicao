package com.br.mesademedicao.util;

import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ConexaoArduino {
    //--Gera a conexão de instacia entre as classes proxy e app
    private ConexaoArduino() {
     // Construtor privado para evitar instanciação externa
    }
    private static ConexaoArduino instancia;

    public static synchronized ConexaoArduino getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoArduino();
        }
        return instancia;
    }//--

    private SerialPort porta;
    private Scanner leitor;
    private OutputStream saida;
    
    public boolean conectar(String nomePorta, int baudRate) {
        // Tenta encontrar a porta
        porta = SerialPort.getCommPort(nomePorta);
        
        // Configurações padrão
        porta.setBaudRate(baudRate);
        porta.setNumDataBits(8);
        porta.setNumStopBits(SerialPort.ONE_STOP_BIT);
        porta.setParity(SerialPort.NO_PARITY);
        
        // Define timeout para evitar que o programa trave infinitamente
        porta.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

        if (!porta.openPort()) {
            System.err.println("ERRO: Não foi possível abrir a porta " + nomePorta);
            System.err.println("Verifique se o Monitor Serial do Arduino está aberto ou se o cabo está conectado.");
            return false;
        }

        // IMPORTANTE: Aguarda o Arduino reiniciar após a abertura da porta
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        InputStream entrada = porta.getInputStream();
        saida = porta.getOutputStream();
        leitor = new Scanner(entrada);

        iniciarLeitura();

        System.out.println("SUCESSO: Conectado ao Arduino em " + nomePorta);
        return true;
    }

    private void iniciarLeitura() {
        Thread leitura = new Thread(() -> {
            System.out.println("Monitorando dados do Arduino...");
            while (porta != null && porta.isOpen()) {
                try {
                    // Verifica se há dados para ler antes de chamar o Scanner
                    if (porta.bytesAvailable() > 0) {
                        if (leitor.hasNextLine()) {
                            String resposta = leitor.nextLine();
                            System.out.println("Arduino diz: " + resposta);
                        }
                    }
                    Thread.sleep(20); // Pequena pausa para não sobrecarregar a CPU
                } catch (Exception e) {
                    System.err.println("Erro na leitura serial: " + e.getMessage());
                    break;
                }
            }
        });
        leitura.setDaemon(true);
        leitura.start();
    }

    public synchronized void enviarComando(String comando) {
        if(saida == null ){
                System.out.print("aq");
        }
        
        try {
            if (saida != null) {
                saida.write((comando + "\n").getBytes());
                saida.flush();
                System.out.println("Comando enviado: " + comando);
            }
        } catch (Exception e) {
            System.err.println("Erro ao enviar comando: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (porta != null && porta.isOpen()) {
                porta.closePort();
                System.out.println("Conexão serial encerrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}