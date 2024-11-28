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
}
