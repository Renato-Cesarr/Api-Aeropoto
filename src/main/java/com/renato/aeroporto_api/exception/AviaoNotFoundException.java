package com.renato.aeroporto_api.exception;

public class AviaoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public AviaoNotFoundException(String message) {
        super(message);
    }
}