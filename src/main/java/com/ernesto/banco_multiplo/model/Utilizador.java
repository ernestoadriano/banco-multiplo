package com.ernesto.banco_multiplo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilizador")
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome_utilizador;

    @Column(nullable = false)
    private String palavra_passe;

    @OneToOne
    @JoinColumn(name = "id_pessoa", unique = true)
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_utilizador() {
        return nome_utilizador;
    }

    public void setNome_utilizador(String nome_utilizador) {
        this.nome_utilizador = nome_utilizador;
    }

    public String getPalavra_passe() {
        return palavra_passe;
    }

    public void setPalavra_passe(String palavra_passe) {
        this.palavra_passe = palavra_passe;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
