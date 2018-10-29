package com.ciberman.atm.models;

import com.ciberman.atm.exceptions.InvalidOperationException;

import java.math.BigDecimal;

public class CheckingAccount extends Account {

    private BigDecimal overdraft;

    public CheckingAccount(BigDecimal balance, BigDecimal overdraft) {
        super(balance);
        this.overdraft = overdraft;
    }

    @Override
    public String getName() {
        return "Cuenta corriente";
    }

    @Override
    public void withdraw(BigDecimal amount) throws InvalidOperationException {
        BigDecimal balanceAfter = getBalance().subtract(amount);
        if (balanceAfter.compareTo(this.overdraft) < 0) {
            throw new InvalidOperationException("Se superó el máximo monto descubierto");
        }
        super.withdraw(amount);
    }

    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }
}
