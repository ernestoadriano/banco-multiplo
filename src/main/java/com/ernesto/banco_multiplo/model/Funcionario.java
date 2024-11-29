package com.ernesto.banco_multiplo.model;

import com.ernesto.banco_multiplo.model.enum_.TipoFuncionario;
import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{

    @OneToOne
    @JoinColumn(name = "id_utilizador_funcionario")
    private UtilizadorFuncionario utilizadorFuncionario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_funcionario")
    private TipoFuncionario tipoFuncionario;


    public UtilizadorFuncionario getUtilizadorFuncionario() {
        return utilizadorFuncionario;
    }

    public void setUtilizadorFuncionario(UtilizadorFuncionario utilizadorFuncionario) {
        this.utilizadorFuncionario = utilizadorFuncionario;
    }
}
