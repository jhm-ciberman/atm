package atm.exceptions;

import java.math.BigInteger;

public class InvalidCardException extends Exception {
    private BigInteger cardNumber;

    public InvalidCardException(BigInteger cardNumber) {

        this.cardNumber = cardNumber;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }
}
