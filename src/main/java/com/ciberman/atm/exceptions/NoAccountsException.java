package com.ciberman.atm.exceptions;

import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.controllers.MainMenuController;

public class NoAccountsException extends ATMError {
    public NoAccountsException() {
        super("No tiene ninguna cuenta asociada a esta tarjeta",
                "Consulte en una sucursal del Banco de la Plaza sobre las cuentas disponibles");
    }

    @Override
    public Class<? extends BaseController> redirect() {
        return MainMenuController.class;
    }
}
