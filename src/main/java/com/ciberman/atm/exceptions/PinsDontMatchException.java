package com.ciberman.atm.exceptions;

import com.ciberman.atm.views.BaseView;
import com.ciberman.atm.views.password.ChangePinView;

public class PinsDontMatchException extends ATMError {

    public PinsDontMatchException() {
        super("El pin no coincide.", "Por favor intente de nuevo.");
    }

    @Override
    public Class<? extends BaseView> redirect() {
        return ChangePinView.class;
    }
}
