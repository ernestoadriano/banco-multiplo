package com.ernesto.banco_multiplo.entity.banco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcioanrios")
public class Funcionario extends Pessoa{

    @Column(nullable = false)
    private String funcao;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
