package com.ernesto.banco_multiplo.crud.model;

import com.ernesto.banco_multiplo.crud.enums.ModalidadePagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "conta_prazo")
public class ContaPrazo extends Conta{

    private Double taxaEmVigor;

    private Double juroAcumulado;

    private Date prazoVencimento;

    @Enumerated(EnumType.STRING)
    private ModalidadePagamento modalidadePagamento;

    public Double getTaxaEmVigor() {
        return taxaEmVigor;
    }

    public void setTaxaEmVigor(Double taxaEmVigor) {
        this.taxaEmVigor = taxaEmVigor;
    }

    public Double getJuroAcumulado() {
        return juroAcumulado;
    }

    public void setJuroAcumulado(Double juroAcumulado) {
        this.juroAcumulado = juroAcumulado;
    }

    public Date getPrazoVencimento() {
        return prazoVencimento;
    }

    public void setPrazoVencimento(Date prazoVencimento) {
        this.prazoVencimento = prazoVencimento;
    }

    public ModalidadePagamento getModalidadePagamento() {
        return modalidadePagamento;
    }

    public void setModalidadePagamento(ModalidadePagamento modalidadePagamento) {
        this.modalidadePagamento = modalidadePagamento;
    }
}
