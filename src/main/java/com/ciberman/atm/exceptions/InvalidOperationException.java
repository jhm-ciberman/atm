package com.ciberman.atm.exceptions;

public class InvalidOperationException extends ATMError {
    public InvalidOperationException(String description) {
        super("Operación inválida", description);
    }

}
