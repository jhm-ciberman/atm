package com.ciberman.atm.models;

import com.ciberman.atm.exceptions.InvalidCardRangeException;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bank {
    private String name;

    private BigInteger minRange;

    private BigInteger maxRange;

    private Set<Card> cards = new LinkedHashSet<>();

    public Bank(String name, BigInteger minRange, BigInteger maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) throws InvalidCardRangeException {
        if (!this.isInRange(card.getNumber())) {
            throw new InvalidCardRangeException();
        }
        this.cards.add(card);
    }

    public Set<Card> getCards() {
        return this.cards;
    }

    public boolean isInRange(BigInteger number) {
        return number.max(this.minRange)
                .min(this.maxRange)
                .equals(number);
    }
}
