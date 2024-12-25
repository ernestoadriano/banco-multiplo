package com.ernesto.banco_multiplo.crud.model;

import com.ernesto.banco_multiplo.crud.enums.TipoFuncionario;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{

    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipoFuncionario;

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }
}
