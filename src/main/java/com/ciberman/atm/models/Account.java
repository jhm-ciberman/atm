package com.ciberman.atm.models;

import com.ciberman.atm.exceptions.InvalidOperationException;

import java.math.BigDecimal;

public abstract class Account {
    private BigDecimal balance;

    private String cbu;

    public Account(String cbu) {
        this.balance = new BigDecimal("0");
        this.cbu = cbu;
    }

    public Account(String cbu, BigDecimal balance) {
        this.cbu = cbu;
        this.balance = balance;
    }

    @SuppressWarnings("SameReturnValue")
    public String getName() {
        return "Cuenta";
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCbu() {
        return cbu;
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws InvalidOperationException {
        this.balance = this.balance.subtract(amount);
    }
}
