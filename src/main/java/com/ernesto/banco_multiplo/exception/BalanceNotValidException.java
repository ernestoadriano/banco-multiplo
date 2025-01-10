package com.ernesto.banco_multiplo.exception;

public class BalanceNotValidException extends RuntimeException{

    public BalanceNotValidException(String message) {
        super(message);
    }
}
