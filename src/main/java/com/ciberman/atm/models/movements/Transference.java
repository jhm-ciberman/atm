package com.ciberman.atm.models.movements;

import com.ciberman.atm.models.account.Account;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents a Transference Movement from one account to another.
 */
public class Transference extends Movement {

    private final Account otherAccount;

    /**
     * Creates a new Transference instance
     *
     * @param date         The movement date
     * @param account      The account where the movement is applied
     * @param otherAccount The other account that received or provided the money
     * @param amount       The amount that was added (positive amount) or subtracted (negative) from the account
     */
    public Transference(Date date, Account account, Account otherAccount, BigDecimal amount) {
        super(date, account, amount);
        this.otherAccount = otherAccount;
    }

    public Account getOtherAccount() {
        return this.otherAccount;
    }

    @Override
    public String getDescription() {
        if (this.isIncome()) {
            return "Transferencia entrante";
        } else {
            return "Transferencia saliente";
        }
    }
}
