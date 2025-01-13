
package com.renato.aeroporto_api.exception;

public class AeroportoAlreadyExistsException extends RuntimeException {
    public AeroportoAlreadyExistsException(String message) {
        super(message);
    }
}
