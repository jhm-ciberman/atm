package com.ciberman.atm.services;

import com.ciberman.atm.models.*;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ATMProvider {

    /**
     * @return The ATM root Model
     */
    public ATM getAtm() {
        ATM atm = new ATM();
        this.seed(atm);
        return atm;
    }


    /**
     * Seeds the passed ATM Database Model with random data
     *
     * @param atm The ATM Database model to seed
     */
    private void seed(ATM atm) {
        User user = new User("Javier", "Mora");
        Card card = new Card(new BigInteger("123456789"), "1234", user);
        atm.cards.add(card);

        Account account1 = new SavingsAccount("123", new BigDecimal("1234"));
        card.addAccount(account1);

        Account account2 = new SavingsAccount("456", new BigDecimal("5678"));
        card.addAccount(account2);


    }

}
