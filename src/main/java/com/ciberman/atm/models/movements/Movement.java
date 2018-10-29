package com.ciberman.atm.models.movements;

import com.ciberman.atm.models.account.Account;

import java.math.BigDecimal;

public interface Movement {

    BigDecimal getAmount();

    Account getAccount();

    boolean isGainFor(Account account);

    boolean isLossFor(Account account);
}
