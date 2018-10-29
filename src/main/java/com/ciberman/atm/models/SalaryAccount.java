package com.ciberman.atm.models;

import java.math.BigDecimal;

public class SalaryAccount extends SavingsAccount {

    public SalaryAccount(String cbu, BigDecimal balance) {
        super(cbu, balance);
    }

    @Override
    public String getName() {
        return "Cuenta Sueldo";
    }
}
