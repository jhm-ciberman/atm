package com.ciberman.atm.models.movements;

import com.ciberman.atm.models.account.Account;

import java.math.BigDecimal;

public class WithdrawMovement implements Movement {

    private Account account;

    private BigDecimal amount;

    public WithdrawMovement(Account account, BigDecimal amount) {
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
        return false;
    }

    @Override
    public boolean isLossFor(Account account) {
        return (this.account == account);
    }
}
