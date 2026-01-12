package com.br.mesademedicao.util;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ConexaoArduino {
    public static void main(String[] args) {
        // Lista as portas disponíveis
        SerialPort[] portas = SerialPort.getCommPorts();
        System.out.println("Selecione a porta do seu Arduino:");
        
        for (int i = 0; i < portas.length; i++) {
            System.out.println(i + " - " + portas[i].getSystemPortName());
        }

        // Escolhe a primeira porta (ajuste conforme necessário)
        SerialPort portaSelecionada = portas[0];

        // Configura parâmetros (devem ser iguais aos do Arduino)
        portaSelecionada.setBaudRate(9600);

        if (portaSelecionada.openPort()) {
            System.out.println("Porta aberta com sucesso!");
        } else {
            System.out.println("Falha ao abrir a porta.");
            return;
        }

        // Thread para ler os dados vindos do Arduino
        Thread threadLeitura = new Thread(() -> {
            Scanner scannerSerial = new Scanner(portaSelecionada.getInputStream());
            while (scannerSerial.hasNextLine()) {
                System.out.println("Arduino diz: " + scannerSerial.nextLine());
            }
        });
        threadLeitura.start();

        // Exemplo: Enviando comando '1' para ligar o LED
        try {
            portaSelecionada.getOutputStream().write('1');
            portaSelecionada.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}