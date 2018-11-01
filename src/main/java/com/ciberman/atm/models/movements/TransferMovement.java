package com.ciberman.atm.models.movements;

import com.ciberman.atm.models.account.Account;

import java.math.BigDecimal;

public class TransferMovement implements Movement {

    private final Account sourceAccount;

    private final Account destinationAccount;

    private final BigDecimal amount;

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
