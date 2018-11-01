package com.ciberman.atm.exceptions;

public class PinsDontMatchException extends ATMError {

    public PinsDontMatchException() {
        super("El pin no coincide.", "Por favor intente de nuevo.");
    }
}
