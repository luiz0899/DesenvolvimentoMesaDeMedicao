
package com.br.mesademedicao.entity;


public class Lista {
    
    private Integer pedido;
    private String cliente;
    private String Descricao;
    private String produto;
    private Integer quantidade;
    private Integer medida;
    private boolean corteConcluido;

    public Lista(Integer pedido, String cliente, String Descricao, String produto, Integer quantidade, Integer medida, boolean corteConcluido) {
        this.pedido = pedido;
        this.cliente = cliente;
        this.Descricao = Descricao;
        this.produto = produto;
        this.quantidade = quantidade;
        this.medida = medida;
        this.corteConcluido = corteConcluido;
    } 

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getMedida() {
        return medida;
    }

    public void setMedida(Integer medida) {
        this.medida = medida;
    }

    public boolean isCorteConcluido() {
        return corteConcluido;
    }

    public void setCorteConcluido(boolean corteConcluido) {
        this.corteConcluido = corteConcluido;
    }
    
    
}
