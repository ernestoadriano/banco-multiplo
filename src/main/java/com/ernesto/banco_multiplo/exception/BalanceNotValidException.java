package com.ernesto.banco_multiplo.exception;

/*
 * @author: Ernesto Adriano
 * */
public class BalanceNotValidException extends RuntimeException{

    public BalanceNotValidException(String message) {
        super(message);
    }
}
