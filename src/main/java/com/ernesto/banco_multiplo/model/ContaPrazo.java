package com.ernesto.banco_multiplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "conta_prazo")
public class ContaPrazo extends Conta_Banco {

    private Double taxa_juros_em_vigor;
    private Double juros_acumulados;
    private Date data_vencimento;
    private String modalidade;


    public Double getTaxa_juros_em_vigor() {
        return taxa_juros_em_vigor;
    }

    public void setTaxa_juros_em_vigor(Double taxa_juros_em_vigor) {
        this.taxa_juros_em_vigor = taxa_juros_em_vigor;
    }

    public Double getJuros_acumulados() {
        return juros_acumulados;
    }

    public void setJuros_acumulados(Double juros_acumulados) {
        this.juros_acumulados = juros_acumulados;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
}
