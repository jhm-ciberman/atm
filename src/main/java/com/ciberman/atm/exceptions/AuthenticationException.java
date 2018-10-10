package com.ciberman.atm.exceptions;

import com.ciberman.atm.Views;
import com.ciberman.atm.services.Authenticatable;

public class AuthenticationException extends ATMError {
    private Authenticatable authenticatable;

    public AuthenticationException(Authenticatable authenticatable) {
        super("El pin ingresado es incorrecto", "Intente nuevamente");
        this.authenticatable = authenticatable;
    }

    public Authenticatable getAuthenticatable() {
        return authenticatable;
    }

    @Override
    public String redirect() {
        return Views.LOGIN;
    }
}
