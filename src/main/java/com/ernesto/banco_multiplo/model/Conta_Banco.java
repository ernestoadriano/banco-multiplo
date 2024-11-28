package com.ernesto.banco_multiplo.model;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class Conta_Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numero_conta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_abertura;
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
