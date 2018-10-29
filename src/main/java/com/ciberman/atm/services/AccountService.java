package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.InvalidOperationException;
import com.ciberman.atm.models.account.Account;

import java.math.BigDecimal;

public class AccountService {

    public void withdraw(Account account, String amountString) {
        BigDecimal amount = new BigDecimal(amountString);
        if (this.checkIsInvalid(amount)) {

            return;
        }

        account.deposit(amount);
    }

    public void deposit(Account account, String amountString) {
        BigDecimal amount = new BigDecimal(amountString);
        if (this.checkIsInvalid(amount)) {

            return;
        }

        account.deposit(amount);
    }

    public void transfer(Account sourceAccount, Account destinationAccount, String amountString) throws InvalidOperationException {
        BigDecimal amount = new BigDecimal(amountString);

        sourceAccount.withdraw(amount);
        destinationAccount.deposit(amount);


    }

    private boolean checkIsInvalid(BigDecimal amount) {
        return (amount.remainder(new BigDecimal("100")).equals(BigDecimal.ZERO));
    }

}
