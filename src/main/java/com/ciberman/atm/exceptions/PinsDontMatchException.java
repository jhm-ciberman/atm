package com.ciberman.atm.exceptions;

import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.controllers.password.ChangePasswordController;

public class PinsDontMatchException extends ATMError {

    public PinsDontMatchException() {
        super("El pin no coincide.", "Por favor intente de nuevo.");
    }

    @Override
    public Class<? extends BaseController> redirect() {
        return ChangePasswordController.class;
    }
}
