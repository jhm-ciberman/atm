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
        return "Cuenta";
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void deposit(BigInteger amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigInteger amount) {
        this.balance = this.balance.subtract(amount);
    }
}
