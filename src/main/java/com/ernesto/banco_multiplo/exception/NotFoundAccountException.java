package com.ernesto.banco_multiplo.exception;

public class NotFoundAccountException extends RuntimeException{

    public NotFoundAccountException(String message) {
        super(message);
    }
}
