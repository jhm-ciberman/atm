package com.ciberman.atm.exceptions;

import com.ciberman.atm.Views;

public class UnauthorizedException extends ATMError {

    public UnauthorizedException() {
        super("No tiene permiso para realizar esa acción", "Intente ingresar nuevamente");
    }

    @Override
    public String redirect() {
        return Views.LOGIN;
    }
}
