package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.CardNotFoundException;
import com.ciberman.atm.models.ATM;
import com.ciberman.atm.models.Card;
import com.google.inject.Inject;

import java.math.BigInteger;

public class CardFinder {

    @Inject
    private ATMProvider atmProvider;

    public Card findCard(BigInteger number) throws CardNotFoundException {
        ATM atm = atmProvider.getAtm();
        Card card = atm.cards.stream()
                .filter(e -> e.getNumber().equals(number))
                .findFirst()
                .orElse(null);

        if (card == null) {
            throw new CardNotFoundException(number);
        }

        return card;
    }
}
