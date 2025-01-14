package com.renato.aeroporto_api.exception;



public class InvalidNumeroDeSerieException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidNumeroDeSerieException(String message) {
        super(message);
    }
	
}
