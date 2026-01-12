package com.br.mesademedicao.service.Impl;

import com.br.mesademedicao.entity.Controle;
import com.br.mesademedicao.service.OperacaoManual;
import com.br.mesademedicao.service.proxy.OperacaoManualProxy;
import java.io.IOError;


public class OperacaoManualImpl implements OperacaoManual{
    
    private final OperacaoManualProxy proxy;
    private Controle controle ;    
    
    public OperacaoManualImpl(OperacaoManualProxy proxy){
        this.proxy = proxy;
        
    }
       @Override
    public void operacaoJogEsq(boolean direcao, Integer velocidade) {
        
        try {
            if(velocidade < 0 || velocidade == null ){ throw new IllegalArgumentException("Velocidade deve ser maior que zero");}
            
            proxy.operacaoJogEsq(direcao, velocidade);
            
        } catch (Exception e) {
            throw new IllegalArgumentException (e + "Direção esquerda ou velocidade Inconsistente.");
        }
    }

    @Override
    public void operacaoJogDir(boolean direcao, Integer velocidade) {
        
        try {
            if(velocidade < 0 || velocidade == null ){ throw new IllegalArgumentException("Velocidade deve ser maior que zero");}
            
            proxy.operacaoJogDir(direcao, velocidade);
            
        } catch (Exception e) {
            throw new IllegalArgumentException (e + "Direção direita ou velocidade Inconsistente.");
        }
    }

    @Override
    public void ativarFreio() {
        
        try {
            if (controle != null) {
                controle.setFreio(true);
            }
            proxy.ativarFreio();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ativar freio: " + e.getMessage(), e);
        }
    }

    @Override
    public void liberarFreio() {
        
        try {
            if (controle != null) {
                controle.setFreio(false);
            }
            proxy.liberarFreio();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao liberar freio: " + e.getMessage(), e);
        }
        
    }

    @Override
    public void referenciar() {
        
        try {
            if (controle != null) {
                controle.setRefMsea(true);
            }
            proxy.referenciar();
        } catch (Exception e) {
            throw new RuntimeException("Erro no referenciamento: " + e.getMessage(), e);
        }
    }
}
