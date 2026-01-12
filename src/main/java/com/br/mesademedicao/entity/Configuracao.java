package com.br.mesademedicao.entity;

public class Configuracao {
    
    private Integer passosPorRevolucao;
    private Integer rpmManu;
    private Integer rpmAut;
    private Integer rpmRef;
    private Double refPiCalculo;

    public Configuracao(Integer passosPorRevolucao, Integer rpmManu, Integer rpmAut, Integer rpmRef, Double refPiCalculo) {
        this.passosPorRevolucao = passosPorRevolucao;
        this.rpmManu = rpmManu;
        this.rpmAut = rpmAut;
        this.rpmRef = rpmRef;
        this.refPiCalculo = refPiCalculo;
    }

    public Integer getPassosPorRevolucao() {
        return passosPorRevolucao;
    }

    public void setPassosPorRevolucao(Integer passosPorRevolucao) {
        this.passosPorRevolucao = passosPorRevolucao;
    }

    public Integer getRpmManu() {
        return rpmManu;
    }

    public void setRpmManu(Integer rpmManu) {
        this.rpmManu = rpmManu;
    }

    public Integer getRpmAut() {
        return rpmAut;
    }

    public void setRpmAut(Integer rpmAut) {
        this.rpmAut = rpmAut;
    }

    public Integer getRpmRef() {
        return rpmRef;
    }

    public void setRpmRef(Integer rpmRef) {
        this.rpmRef = rpmRef;
    }

    public Double getRefPiCalculo() {
        return refPiCalculo;
    }

    public void setRefPiCalculo(Double refPiCalculo) {
        this.refPiCalculo = refPiCalculo;
    }
    
    
    
}
