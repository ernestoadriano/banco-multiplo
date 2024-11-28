package com.ernesto.banco_multiplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta_ordem")
public class ContaOrdem extends Conta_Banco {

    private String regimeTitularidade;

    public String getRegimeTitularidade() {
        return regimeTitularidade;
    }

    public void setRegimeTitularidade(String regimeTitularidade) {
        this.regimeTitularidade = regimeTitularidade;
    }
}
