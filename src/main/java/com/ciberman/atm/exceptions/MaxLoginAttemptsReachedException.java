package com.ciberman.atm.exceptions;

public class MaxLoginAttemptsReachedException extends ATMError {

    public MaxLoginAttemptsReachedException() {
        super(
            "Tarjeta retenida",
            "Ha ingresado un PIN incorrecto demasiadas veces. Consulte en la sucursal de su banco más cercana."
        );
    }

}
