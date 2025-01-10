package com.ernesto.banco_multiplo.entity.banco;

import com.ernesto.banco_multiplo.entity.enums.TipoConta;
import jakarta.persistence.*;

import java.util.Date;


/*
 * @author: Ernesto Adriano
 * */

@Entity
@Table(name = "contas_bancarias")
public class ContaBanco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String numeroConta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date dataAbertura;

    @Column(nullable = false)
    private Double saldo;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public ContaBanco debit(Double valor) {
        this.setSaldo(getSaldo() - valor);
        return this;
    }

    public ContaBanco credit(Double valor) {
        this.setSaldo(getSaldo() + valor);
        return this;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
}
