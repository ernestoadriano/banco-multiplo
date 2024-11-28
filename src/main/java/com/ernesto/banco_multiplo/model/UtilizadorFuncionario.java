package com.ernesto.banco_multiplo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilizador_funcionario")
public class UtilizadorFuncionario extends Utilizador{
    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
