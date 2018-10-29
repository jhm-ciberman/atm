package com.ciberman.atm.models.movements;

import com.ciberman.atm.models.account.Account;

import java.math.BigDecimal;

public class DepositMovement implements Movement {

    private Account account;

    private BigDecimal amount;

    public DepositMovement(Account account, BigDecimal amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public boolean isGainFor(Account account) {
        return (this.account == account);
    }

    @Override
    public boolean isLossFor(Account account) {
        return false;
    }
}
