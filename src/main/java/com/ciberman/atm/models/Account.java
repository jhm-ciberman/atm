package com.ciberman.atm.models;

import java.math.BigInteger;

public class Account {
    private BigInteger balance;

    public Account() {
        this.balance = new BigInteger("0");
    }

    public Account(BigInteger balance) {
        this.balance = balance;
    }

    public String getName() {
        return "Bank Account";
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }
}
