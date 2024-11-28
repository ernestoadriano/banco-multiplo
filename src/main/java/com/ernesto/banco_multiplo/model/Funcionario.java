package com.ernesto.banco_multiplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{
    private String tipo_funcionario;
}
