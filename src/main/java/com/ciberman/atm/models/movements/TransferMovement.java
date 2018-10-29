package com.ciberman.atm.models.movements;

import com.ciberman.atm.models.account.Account;

import java.math.BigDecimal;

public class TransferMovement implements Movement {

    private Account sourceAccount;

    private Account destinationAccount;

    private BigDecimal amount;

    public TransferMovement(Account sourceAccount, Account destinationAccount, BigDecimal amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public Account getAccount() {
        return sourceAccount;
    }

    @Override
    public boolean isGainFor(Account account) {
        return (account == destinationAccount);
    }

    @Override
    public boolean isLossFor(Account account) {
        return (account == sourceAccount);
    }
}
