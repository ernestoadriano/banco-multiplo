package com.ernesto.banco_multiplo.dto;

public class ContaOrdemDTO {

    private String numeroConta;
    private double valor;
    private String nrContaDestino;

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNrContaDestino() {
        return nrContaDestino;
    }

    public void setNrContaDestino(String nrContaDestino) {
        this.nrContaDestino = nrContaDestino;
    }
}
