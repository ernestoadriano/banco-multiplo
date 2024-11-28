package com.ernesto.banco_multiplo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "residencia")
public class Residencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cidade_provincia;
    private String rua_av;
    private Integer numero_casa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade_provincia() {
        return cidade_provincia;
    }

    public void setCidade_provincia(String cidade_provincia) {
        this.cidade_provincia = cidade_provincia;
    }

    public String getRua_av() {
        return rua_av;
    }

    public void setRua_av(String rua_av) {
        this.rua_av = rua_av;
    }

    public Integer getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(Integer numero_casa) {
        this.numero_casa = numero_casa;
    }
}
