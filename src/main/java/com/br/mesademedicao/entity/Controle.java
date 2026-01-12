package com.br.mesademedicao.entity;


public class Controle {
    
    private boolean movEsq;
    private boolean movDir;
    private boolean freio;
    private boolean refMsea;
    private Integer velocidade;
    
     public Controle(boolean movEsq, boolean movDir, boolean freio, boolean refMsea) {
        this.movEsq = movEsq;
        this.movDir = movDir;
        this.freio = freio;
        this.refMsea = refMsea;
    }
     
    public Controle (boolean movEsq,Integer velocidade) {
        this.movEsq = movEsq;
        this.velocidade = velocidade; 
    }

    public boolean isMovEsq() {
        return movEsq;
    }

    public void setMovEsq(boolean movEsq) {
        this.movEsq = movEsq;
    }

    public boolean isMovDir() {
        return movDir;
    }

    public void setMovDir(boolean movDir) {
        this.movDir = movDir;
    }

    public boolean isFreio() {
        return freio;
    }

    public void setFreio(boolean freio) {
        this.freio = freio;
    }

    public boolean isRefMsea() {
        return refMsea;
    }

    public void setRefMsea(boolean refMsea) {
        this.refMsea = refMsea;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }
     
    
}
   
