package com.ernesto.banco_multiplo.exception;

/*
 * @author: Ernesto Adriano
 * */
public class NotFoundAccountException extends RuntimeException{

    public NotFoundAccountException(String message) {
        super(message);
    }
}
