package com.br.mesademedicao.entity;

public class Configuracao {
    
    private Integer passosPorRevolucao;
    private Integer microstepping;
    private Integer rpm;
    private Double  passoFuso;
    private Double diametroRoda;
    private Double refPiCalculo;

    public Configuracao(Integer passosPorRevolucao, Integer microstepping, Integer rpm, Double passoFuso, Double diametroRoda, Double refPiCalculo) {
        this.passosPorRevolucao = passosPorRevolucao;
        this.microstepping = microstepping;
        this.rpm = rpm;
        this.passoFuso = passoFuso;
        this.diametroRoda = diametroRoda;
        this.refPiCalculo = refPiCalculo;
    }

    public Integer getPassosPorRevolucao() {
        return passosPorRevolucao;
    }

    public void setPassosPorRevolucao(Integer passosPorRevolucao) {
        this.passosPorRevolucao = passosPorRevolucao;
    }

    public Integer getMicrostepping() {
        return microstepping;
    }

    public void setMicrostepping(Integer microstepping) {
        this.microstepping = microstepping;
    }

    public Integer getRpm() {
        return rpm;
    }

    public void setRpm(Integer rpm) {
        this.rpm = rpm;
    }

    public Double getPassoFuso() {
        return passoFuso;
    }

    public void setPassoFuso(Double passoFuso) {
        this.passoFuso = passoFuso;
    }

    public Double getDiametroRoda() {
        return diametroRoda;
    }

    public void setDiametroRoda(Double diametroRoda) {
        this.diametroRoda = diametroRoda;
    }

    public Double getRefPiCalculo() {
        return refPiCalculo;
    }

    public void setRefPiCalculo(Double refPiCalculo) {
        this.refPiCalculo = refPiCalculo;
    }
}
