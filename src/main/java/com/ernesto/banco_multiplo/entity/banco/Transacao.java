package com.ernesto.banco_multiplo.entity.banco;

import com.ernesto.banco_multiplo.entity.enums.TipoTransacao;
import jakarta.persistence.*;

import java.util.Date;

/*
 @author: Ernesto Adriano
 * */

@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOperacao;

    private Double montanteMovimentado;

    @ManyToOne
    @JoinColumn(name = "id_conta_origem")
    private ContaBanco contaOrigem;

    @ManyToOne
    @JoinColumn(name = "id_conta_destino")
    private ContaBanco contaDestino;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transacao")
    private TipoTransacao tipoTransacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Double getMontanteMovimentado() {
        return montanteMovimentado;
    }

    public void setMontanteMovimentado(Double montanteMovimentado) {
        this.montanteMovimentado = montanteMovimentado;
    }

    public ContaBanco getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaBanco contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaBanco getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaBanco contaDestino) {
        this.contaDestino = contaDestino;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
