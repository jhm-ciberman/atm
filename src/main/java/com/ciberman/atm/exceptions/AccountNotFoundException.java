package com.ciberman.atm.exceptions;

public class AccountNotFoundException extends ATMError {

    private String cbu;

    public AccountNotFoundException(String cbu) {
        this.cbu = cbu;
    }

    public String getCbu() {
        return cbu;
    }
}
