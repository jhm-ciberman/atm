package com.ciberman.atm.exceptions;

import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.controllers.login.LoginController;
import com.ciberman.atm.services.Authenticatable;

public class AuthenticationException extends ATMError {
    private final Authenticatable authenticatable;

    public AuthenticationException(Authenticatable authenticatable) {
        super("El pin ingresado es incorrecto", "Intente nuevamente");
        this.authenticatable = authenticatable;
    }

    public Authenticatable getAuthenticatable() {
        return authenticatable;
    }

    @Override
    public Class<? extends BaseController> redirect() {
        return LoginController.class;
    }
}
