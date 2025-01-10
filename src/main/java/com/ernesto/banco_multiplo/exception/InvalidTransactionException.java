package com.ernesto.banco_multiplo.exception;

public class InvalidTransactionException extends RuntimeException{

    public InvalidTransactionException(String message) {
        super(message);
    }
}
