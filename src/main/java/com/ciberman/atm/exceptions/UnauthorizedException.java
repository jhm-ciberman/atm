package com.ciberman.atm.exceptions;

import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.controllers.login.LoginController;

public class UnauthorizedException extends ATMError {

    public UnauthorizedException() {
        super("No tiene permiso para realizar esa acción", "Intente ingresar nuevamente");
    }

    @Override
    public Class<? extends BaseController> redirect() {
        return LoginController.class;
    }
}
