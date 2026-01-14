package com.br.mesademedicao.service.Impl;

import com.br.mesademedicao.controller.TratamentoDeVariaveis;
import com.br.mesademedicao.entity.Configuracao;
import com.br.mesademedicao.entity.Controle;
import com.br.mesademedicao.service.ConfiguracaoDrive;
import com.br.mesademedicao.service.OperacaoManual;
import com.br.mesademedicao.service.proxy.OperacaoManualProxy;
import java.io.IOError;


public class OperacaoManualImpl implements OperacaoManual{
    
    private OperacaoManualProxy proxy = new OperacaoManualProxy();
    private Configuracao Conf;
    private TratamentoDeVariaveis tratamento;
    private ConfiguracaoDrive configuracaoDrive;
    
    @Override
    public void operacaoJogEsq(Integer velocidade) {
        
        try {
            if(velocidade < 0 || velocidade == null ){ throw new IllegalArgumentException("Velocidade deve ser maior que zero");}
            
            proxy.operacaoJogEsq(velocidade);
            
        } catch (Exception e) {
            throw new IllegalArgumentException (e + "Direção esquerda ou velocidade Inconsistente.");
        }
    }

    @Override
    public void operacaoJogDir(Integer velocidade) {
        
        try {
            if(velocidade < 0 || velocidade == null ){ throw new IllegalArgumentException("Velocidade deve ser maior que zero");}
            
            proxy.operacaoJogDir(velocidade);
            
        } catch (Exception e) {
            throw new IllegalArgumentException (e + "Direção direita ou velocidade Inconsistente.");
        }
    }
    
    @Override
    public void Stop_mov() {
        
        try {
            proxy.Stop_mov();
            
        } catch (Exception e) {
            throw new IllegalArgumentException (e + "Falha ao parar a movmentação.");
        }
    }
    
    @Override
    public void ativarFreio() {
        
        try {
            proxy.ativarFreio();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ativar freio: " + e.getMessage(), e);
        }
    }

    @Override
    public void liberarFreio() {
        
        try {
            proxy.liberarFreio();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao liberar freio: " + e.getMessage(), e);
        }
        
    }

    @Override
    public void referenciar() {
        
        try {
            proxy.referenciar();
        } catch (Exception e) {
            throw new RuntimeException("Erro no referenciamento: " + e.getMessage(), e);
        }
    }

    @Override
    public void AtvMedida(double medida) { 
        try {
            configuracaoDrive = new ConfiguracaoDriveImpl();
            Configuracao cfg = configuracaoDrive.carregarConfig();
            
            Integer passosPorRevolucao = Integer.parseInt(cfg.getPassosPorRevolucao().toString());
            Integer microstepping = Integer.parseInt(cfg.getPassosPorRevolucao().toString());
            double passoFuso = Double.parseDouble(cfg.getMicrostepping().toString());
    
            if(passosPorRevolucao > 0 || passoFuso > 0 || passoFuso > 0 ){          
                   
                Double valPulsoPorMM = (passosPorRevolucao * passoFuso) / passoFuso ;         
                Double pulso = (valPulsoPorMM * medida); 
             
                proxy.AtvMedida(pulso);
            }   

        } catch (Exception e) {
            throw new RuntimeException("Erro no calculo da Medida: " + e.getMessage(),e);

        }
  
    }

    
}
