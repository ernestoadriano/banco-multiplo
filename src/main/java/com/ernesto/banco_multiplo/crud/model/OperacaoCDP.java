package com.ernesto.banco_multiplo.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "operacao_conta_prazo")
public class OperacaoCDP extends Operacao{

    @ManyToOne
    @JoinColumn(name = "conta_origem")
    private ContaPrazo contaOrigem;
    @ManyToOne
    @JoinColumn(name = "conta_destino")
    private ContaPrazo contaDestino;

    public ContaPrazo getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaPrazo contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaPrazo getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaPrazo contaDestino) {
        this.contaDestino = contaDestino;
    }
}
