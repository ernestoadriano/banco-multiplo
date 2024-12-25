package com.ernesto.banco_multiplo.crud.model;


import com.ernesto.banco_multiplo.crud.enums.TipoOperacao;
import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoOperacao tipoOperacao;
    private Double montanteMovimentado;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOperacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Double getMontanteMovimentado() {
        return montanteMovimentado;
    }

    public void setMontanteMovimentado(Double montanteMovimentado) {
        this.montanteMovimentado = montanteMovimentado;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }
}
