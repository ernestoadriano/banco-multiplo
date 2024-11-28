package com.ernesto.banco_multiplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{

    @OneToOne
    @JoinColumn(name = "id_utilizador_funcionario")
    private UtilizadorFuncionario utilizadorFuncionario;

    private String tipo_funcionario;

    public String getTipo_funcionario() {
        return tipo_funcionario;
    }

    public void setTipo_funcionario(String tipo_funcionario) {
        this.tipo_funcionario = tipo_funcionario;
    }

    public UtilizadorFuncionario getUtilizadorFuncionario() {
        return utilizadorFuncionario;
    }

    public void setUtilizadorFuncionario(UtilizadorFuncionario utilizadorFuncionario) {
        this.utilizadorFuncionario = utilizadorFuncionario;
    }
}
