package com.ernesto.banco_multiplo.entity.banco;

import com.ernesto.banco_multiplo.entity.user.User;
import jakarta.persistence.*;

import java.util.Date;
/*
 * @author: Ernesto Adriano
 * */

@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;

    @Column(nullable = false)
    protected String nomeCompleto;

    @Column(nullable = false)
    protected Date dataNascimento;

    @Column(nullable = false, unique = true)
    protected String numBi;

    @Column(nullable = false)
    protected String residencia;

    @Column(nullable = false)
    protected String telefone;

    @Column(nullable = false, unique = true)
    protected String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    protected User user;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumBi() {
        return numBi;
    }

    public void setNumBi(String numBi) {
        this.numBi = numBi;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
