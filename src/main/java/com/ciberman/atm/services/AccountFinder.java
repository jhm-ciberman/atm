package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.AccountNotFoundException;
import com.ciberman.atm.models.ATM;
import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.google.inject.Inject;

public class AccountFinder {

    @Inject
    private ATMProvider atmProvider;

    public Account findAccount(String cbu) throws AccountNotFoundException {
        ATM atm = atmProvider.getAtm();

        for (Card c : atm.cards) {
            for (Account a : c.getAccounts()) {
                if (a.getCbu().equals(cbu)) {
                    return a;
                }
            }
        }

        throw new AccountNotFoundException(cbu);
    }


}
