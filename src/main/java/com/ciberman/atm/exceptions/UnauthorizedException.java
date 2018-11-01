package com.ciberman.atm.exceptions;

public class UnauthorizedException extends ATMError {

    public UnauthorizedException() {
        super("No tiene permiso para realizar esa acción", "Intente ingresar nuevamente");
    }

}
