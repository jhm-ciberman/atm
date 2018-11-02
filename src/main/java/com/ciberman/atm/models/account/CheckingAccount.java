package com.ciberman.atm.models.account;

import com.ciberman.atm.exceptions.InsufficientFundsException;

import java.math.BigDecimal;

public class CheckingAccount extends Account {

    private BigDecimal overdraft;

    public CheckingAccount(String cbu, BigDecimal balance, BigDecimal overdraft) {
        super(cbu, balance);
        this.overdraft = overdraft;
    }

    @Override
    public String getName() {
        return "Cuenta corriente";
    }

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        BigDecimal balanceAfter = getBalance().subtract(amount);
        if (balanceAfter.compareTo(this.overdraft) < 0) {
            throw new InsufficientFundsException(this);
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
