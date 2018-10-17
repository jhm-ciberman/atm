package com.ciberman.atm.services;

import com.ciberman.atm.models.ATM;
import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.User;

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

        Account account1 = new Account(new BigInteger("1234"));
        card.addAccount(account1);

        Account account2 = new Account(new BigInteger("5678"));
        card.addAccount(account2);


    }

}
