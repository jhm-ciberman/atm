package com.ciberman.atm.exceptions;

import java.math.BigInteger;

public class CardNotFoundException extends ATMError {
    private final BigInteger cardNumber;

    public CardNotFoundException(BigInteger cardNumber) {
        super(
                "La tarjeta ingresada no es válida",
                "Compruebe que la tarjeta corresponde a un banco aderhido a la red del Banco de la Plaza."
        );
        this.cardNumber = cardNumber;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

}
