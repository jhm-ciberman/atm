package com.ciberman.atm.models.movements;

import com.ciberman.atm.models.account.Account;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents a money movement from an account.
 * Can be a Withdraw or Deposit.
 */
public class Movement {

    protected Date date;

    protected BigDecimal amount;

    protected Account account;

    /**
     * Creates a new Transference instance
     *
     * @param date    The movement date
     * @param account The account where the movement is applied
     * @param amount  The amount that was added (positive amount) or subtracted (negative) from the account
     */
    public Movement(Date date, Account account, BigDecimal amount) {
        this.date = date;
        this.account = account;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public Account getAccount() {
        return this.account;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDescription() {
        if (this.isIncome()) {
            return "Deposito";
        } else {
            return "Retiro";
        }
    }

    public boolean isIncome() {
        return (this.amount.compareTo(BigDecimal.ZERO) > 0);
    }
}
