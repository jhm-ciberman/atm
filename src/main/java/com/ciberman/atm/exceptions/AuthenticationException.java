package com.ciberman.atm.exceptions;

import com.ciberman.atm.services.Authenticatable;
import com.ciberman.atm.views.BaseView;
import com.ciberman.atm.views.login.EnterPinView;

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
    public Class<? extends BaseView> redirect() {
        return EnterPinView.class;
    }
}
