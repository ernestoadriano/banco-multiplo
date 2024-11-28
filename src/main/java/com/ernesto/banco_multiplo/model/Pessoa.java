package com.ernesto.banco_multiplo.model;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String apelido;
    private Date data_nascimento;
    @Column(unique = true)
    private String nr_bi_passporte;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_registo;
    private String numero_telefone;
    private String nuit;

    @OneToOne
    @JoinColumn(name = "id_utilizador", unique = true)
    private Utilizador utilizador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getNr_bi_passporte() {
        return nr_bi_passporte;
    }

    public void setNr_bi_passporte(String nr_bi_passporte) {
        this.nr_bi_passporte = nr_bi_passporte;
    }

    public Date getData_registo() {
        return data_registo;
    }

    public void setData_registo(Date data_registo) {
        this.data_registo = data_registo;
    }

    public String getNumero_telefone() {
        return numero_telefone;
    }

    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}
