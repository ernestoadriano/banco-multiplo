package com.ernesto.banco_multiplo.crud.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "operacao_conta_ordem")
public class OperacaoCDO extends Operacao{

    @ManyToOne
    @JoinColumn(name = "conta_origem")
    private ContaOrdem contaOrigem;
    @ManyToOne
    @JoinColumn(name = "conta_destino")
    private ContaOrdem contaDestino;

    public ContaOrdem getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaOrdem contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaOrdem getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaOrdem contaDestino) {
        this.contaDestino = contaDestino;
    }
}
