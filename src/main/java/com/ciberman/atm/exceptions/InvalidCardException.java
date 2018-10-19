package com.ciberman.atm.exceptions;

import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.controllers.login.RetrieveCardController;

import java.math.BigInteger;

public class InvalidCardException extends ATMError {
    private final BigInteger cardNumber;

    public InvalidCardException(BigInteger cardNumber) {
        super(
                "La tarjeta ingresada no es válida",
                "Compruebe que la tarjeta corresponde a un banco aderhido a la red del Banco de la Plaza."
        );
        this.cardNumber = cardNumber;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    @Override
    public Class<? extends BaseController> redirect() {
        return RetrieveCardController.class;
    }
}
