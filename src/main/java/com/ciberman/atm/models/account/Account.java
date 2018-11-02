package com.ciberman.atm.models.account;

import com.ciberman.atm.exceptions.InsufficientFundsException;
import com.ciberman.atm.models.movements.Movement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private BigDecimal balance;

    private final String cbu;

    private final List<Movement> movements = new ArrayList<>();

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

    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        if (getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException(this);
        }
        this.balance = this.balance.subtract(amount);
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void addMovement(Movement movement) {
        this.movements.add(movement);
    }
}



