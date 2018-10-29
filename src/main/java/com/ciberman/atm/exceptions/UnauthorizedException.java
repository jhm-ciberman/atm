package com.ciberman.atm.exceptions;

import com.ciberman.atm.views.BaseView;
import com.ciberman.atm.views.login.EnterPinView;

public class UnauthorizedException extends ATMError {

    public UnauthorizedException() {
        super("No tiene permiso para realizar esa acción", "Intente ingresar nuevamente");
    }

    @Override
    public Class<? extends BaseView> redirect() {
        return EnterPinView.class;
    }
}
