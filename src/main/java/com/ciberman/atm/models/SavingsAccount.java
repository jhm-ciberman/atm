package com.ciberman.atm.models;

import java.math.BigDecimal;

public class SavingsAccount extends Account {


    public SavingsAccount(BigDecimal balance) {
        super(balance);
    }

    @Override
    public String getName() {
        return "Caja Ahorro";
    }
}
