package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.AccountNotFoundException;
import com.ciberman.atm.models.ATM;
import com.ciberman.atm.models.ATMProvider;
import com.ciberman.atm.models.Bank;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.account.Account;
import com.google.inject.Inject;

public class AccountFinder {

    @Inject
    private ATMProvider atmProvider;

    public Account findAccount(String cbu) throws AccountNotFoundException {
        ATM atm = atmProvider.getAtm();

        for (Bank bank : atm.banks) {
            for (Card card : bank.getCards()) {
                for (Account account : card.getAccounts()) {
                    if (account.getCbu().equals(cbu)) {
                        return account;
                    }
                }
            }
        }

        throw new AccountNotFoundException(cbu);
    }


}
