package com.ciberman.atm.exceptions;

import com.ciberman.atm.Views;

public class NoAccountsException extends ATMError {
    public NoAccountsException() {
        super("No tiene ninguna cuenta asociada a esta tarjeta",
                "Consulte en una sucursal del Banco de la Plaza sobre las cuentas disponibles");
    }

    @Override
    public String redirect() {
        return Views.MAIN_MENU;
    }
}
