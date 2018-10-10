package com.ciberman.atm.exceptions;

import com.ciberman.atm.Views;

public class PinsDontMatchException extends ATMError {

    public PinsDontMatchException() {
        super("El pin no coincide.", "Por favor intente de nuevo.");
    }

    @Override
    public String redirect() {
        return Views.CHANGE_PASSWORD;
    }
}
