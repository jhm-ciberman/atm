package com.ciberman.atm.exceptions;

import com.ciberman.atm.models.account.Account;

public class InsufficientFundsException extends ATMError {

    private Account account;

    public InsufficientFundsException(Account account) {
        super("Fondos insuficientes", "La cuenta no dispone de los fondos necesarios para realizar la operación");
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
