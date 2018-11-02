package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.CardNotFoundException;
import com.ciberman.atm.models.ATM;
import com.ciberman.atm.models.ATMProvider;
import com.ciberman.atm.models.Bank;
import com.ciberman.atm.models.Card;
import com.google.inject.Inject;

import java.math.BigInteger;

public class CardFinder {

    @Inject
    private ATMProvider atmProvider;

    public Card findCard(BigInteger number) throws CardNotFoundException {
        Bank bank = this.findBank(number);
        return this.findCard(bank, number);
    }

    private Bank findBank(BigInteger number) throws CardNotFoundException {
        ATM atm = atmProvider.getAtm();

        return atm.banks.stream()
                .filter(b -> b.isInRange(number))
                .findFirst()
                .orElseThrow(() -> new CardNotFoundException(number));
    }

    private Card findCard(Bank bank, BigInteger number) throws CardNotFoundException {
        return bank.getCards()
                .stream()
                .filter(c -> c.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new CardNotFoundException(number));
    }
}
