package com.renato.aeroporto_api.exception;

public class AeroportoNotFoundException extends RuntimeException {
    public AeroportoNotFoundException(String message) {
        super(message);
    }
}
