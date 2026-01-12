
package com.br.mesademedicao.service.proxy;

import com.br.mesademedicao.service.OperacaoManual;
import com.br.mesademedicao.util.ConexaoArduino;

public class OperacaoManualProxy implements OperacaoManual {
    
    private final ConexaoArduino arduino; // Conexão direta com hardware
    
    public OperacaoManualProxy(ConexaoArduino arduino) {
        this.arduino = arduino;
    }
    
    @Override
    public void operacaoJogEsq(boolean direcao, Integer velocidade) {
        
        System.out.println(velocidade );
        
    }

    @Override
    public void operacaoJogDir(boolean direcao, Integer velocidade) {
    }
    
    @Override
    public void ativarFreio() {
    }

    @Override
    public void liberarFreio() {
    }

    @Override
    public void referenciar() {
    }

 
  
}
