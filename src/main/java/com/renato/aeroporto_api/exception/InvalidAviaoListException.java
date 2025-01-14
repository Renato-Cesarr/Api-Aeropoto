package com.renato.aeroporto_api.exception;

public class InvalidAviaoListException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidAviaoListException(String message) {
        super(message);
    }

}
