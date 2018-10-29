package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.InvalidCardRangeException;
import com.ciberman.atm.models.ATM;
import com.ciberman.atm.models.Bank;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.User;
import com.ciberman.atm.models.account.SavingsAccount;

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
        Bank bank = new Bank("Banco de la Plaza", new BigInteger("0"), new BigInteger("999999999"));
        atm.banks.add(bank);

        try {
            User user = new User("Javier", "Mora");
            Card card = new Card(new BigInteger("123456789"), "1234", user);

            card.addAccount(new SavingsAccount("123", new BigDecimal("1234")));
            card.addAccount(new SavingsAccount("456", new BigDecimal("5678")));

            bank.addCard(card);
        } catch (InvalidCardRangeException e) {
            e.printStackTrace();
        }

    }

}
