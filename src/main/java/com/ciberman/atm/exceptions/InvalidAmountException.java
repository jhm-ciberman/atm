package com.ciberman.atm.exceptions;

public class InvalidAmountException extends ATMError {

    public InvalidAmountException() {
        super("El monto introducido no es válido", "Intente nuevamente");
    }
}
