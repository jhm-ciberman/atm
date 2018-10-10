package com.ciberman.atm.services;

import com.ciberman.atm.models.ATM;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.User;
import com.google.inject.Inject;

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
        User user = new User();
        Card card = new Card(user, new BigInteger("123456789"), "1234");
        atm.cards.add(card);
        atm.users.add(user);
    }

}
