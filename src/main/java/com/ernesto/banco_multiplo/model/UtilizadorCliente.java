package com.ernesto.banco_multiplo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilizador_cliente")
public class UtilizadorCliente extends Utilizador{

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
