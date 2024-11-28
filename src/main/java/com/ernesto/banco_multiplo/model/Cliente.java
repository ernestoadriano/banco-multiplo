package com.ernesto.banco_multiplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

    @OneToOne
    @JoinColumn(name = "id_utilizador_cliente")
    private UtilizadorCliente utilizadorCliente;
}
