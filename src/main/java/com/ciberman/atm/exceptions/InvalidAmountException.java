package com.ciberman.atm.exceptions;

import com.ciberman.atm.views.BaseView;
import com.ciberman.atm.views.MainMenuView;
import org.jetbrains.annotations.Nullable;

public class InvalidAmountException extends ATMError {

    private Class<? extends BaseView> redirectTo = MainMenuView.class;

    public InvalidAmountException(Class<? extends BaseView> redirectTo) {
        super("El monto introducido no es válido", "Intente nuevamente");
        this.redirectTo = redirectTo;
    }

    public void setRedirectTo(Class<? extends BaseView> redirectTo) {
        this.redirectTo = redirectTo;
    }

    @Override
    public @Nullable Class<? extends BaseView> redirect() {
        return this.redirectTo;
    }
}
