package com.ernesto.banco_multiplo.model.enum_;

public enum TipoFuncionario {
    GA("GERENTE_ADMIN"),
    GB("GERENTE_BASE")
    ;

    private String nome;

    TipoFuncionario(String nome) {
        this.nome = nome;
    }
}
