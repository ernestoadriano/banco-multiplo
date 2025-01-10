package com.ernesto.banco_multiplo.entity.enums;

public enum TipoTransacao {

    TRANSFERENCIA("Transferencia"),
    DEPOSITO("Deposito"),
    PAGAMENTO("Pagamento");

    private String tipoTransacao;

    private TipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }
}
