
package com.br.mesademedicao.service.proxy;

import com.br.mesademedicao.service.OperacaoManual;
import com.br.mesademedicao.util.ConexaoArduino;

public class OperacaoManualProxy implements OperacaoManual {
    
    
    //- instancia a conexão com arduino
    private final ConexaoArduino arduino;
    
      // Usa a instância Singleton
    public OperacaoManualProxy() {      
        this.arduino = ConexaoArduino.getInstancia();
    }
    //-
    
    @Override
    public void operacaoJogEsq(Integer velocidade) {          
       arduino.getInstancia().enviarComando("JOG_ESQ:" + velocidade);              
    }
    @Override
    public void operacaoJogDir(Integer velocidade) {
        arduino.getInstancia().enviarComando("JOG_DIR:" + velocidade);
    }
      @Override
    public void Stop_mov() {
        arduino.getInstancia().enviarComando("STOP_MOV");
    }
    @Override
    public void ativarFreio() {
        arduino.getInstancia().enviarComando("ATV_FREIO");
    }
    @Override
    public void liberarFreio() {
        arduino.getInstancia().enviarComando("DES_FREIO");   
    }
    @Override
    public void referenciar() {
        arduino.getInstancia().enviarComando("REF");
    }

    @Override
    public void AtvMedida(double medida) {
        arduino.getInstancia().enviarComando("MED:" + medida);
    }

 
  
}
