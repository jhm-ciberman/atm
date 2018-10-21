package com.ciberman.atm.models;

import java.math.BigDecimal;

public class SalaryAccount extends SavingsAccount {

    public SalaryAccount(BigDecimal balance) {
        super(balance);
    }

    @Override
    public String getName() {
        return "Cuenta Sueldo";
    }
}
