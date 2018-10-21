package com.ciberman.atm.exceptions;

import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.controllers.MainMenuController;
import org.jetbrains.annotations.Nullable;

public class InvalidAmountException extends ATMError {

    private Class<? extends BaseController> redirectTo = MainMenuController.class;

    public InvalidAmountException(Class<? extends BaseController> redirectTo) {
        super("El monto introducido no es válido", "Intente nuevamente");
        this.redirectTo = redirectTo;
    }

    public void setRedirectTo(Class<? extends BaseController> redirectTo) {
        this.redirectTo = redirectTo;
    }

    @Override
    public @Nullable Class<? extends BaseController> redirect() {
        return this.redirectTo;
    }
}
