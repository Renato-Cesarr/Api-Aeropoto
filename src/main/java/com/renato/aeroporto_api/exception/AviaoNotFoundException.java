package com.renato.aeroporto_api.exception;

public class AviaoNotFoundException extends RuntimeException {
    public AviaoNotFoundException(String message) {
        super(message);
    }
}