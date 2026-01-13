
package com.br.mesademedicao.service;

public interface OperacaoManual {
    
    public void operacaoJogEsq(Integer velocidade);
    
    public void operacaoJogDir(Integer velocidade);
    
    public void AtvMedida(double Medida);
    
    public void Stop_mov();

    public void ativarFreio();

    public void liberarFreio();

    public void referenciar();
    
}
