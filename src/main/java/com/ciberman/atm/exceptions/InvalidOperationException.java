package com.ciberman.atm.exceptions;

import com.ciberman.atm.views.BaseView;
import com.ciberman.atm.views.MainMenuView;
import org.jetbrains.annotations.Nullable;

public class InvalidOperationException extends ATMError {
    public InvalidOperationException(String description) {
        super("Operación inválida", description);
    }

    @Override
    public @Nullable Class<? extends BaseView> redirect() {
        return MainMenuView.class;
    }
}
