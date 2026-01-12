
package com.br.mesademedicao.service;

public interface OperacaoManual {
    
    public void operacaoJogEsq(boolean direcao, Integer velocidade);
    
    public void operacaoJogDir(boolean direcao, Integer velocidade);

    public void ativarFreio();

    public void liberarFreio();

    public void referenciar();
    
}
