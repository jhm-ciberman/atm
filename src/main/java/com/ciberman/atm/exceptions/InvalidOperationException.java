package com.ciberman.atm.exceptions;

import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.controllers.MainMenuController;
import org.jetbrains.annotations.Nullable;

public class InvalidOperationException extends ATMError {
    public InvalidOperationException(String description) {
        super("Operación inválida", description);
    }

    @Override
    public @Nullable Class<? extends BaseController> redirect() {
        return MainMenuController.class;
    }
}
