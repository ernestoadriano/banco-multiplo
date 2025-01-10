package com.ernesto.banco_multiplo.exception;

/*
 * @author: Ernesto Adriano
 * */
public class InvalidTransactionException extends RuntimeException{

    public InvalidTransactionException(String message) {
        super(message);
    }
}
