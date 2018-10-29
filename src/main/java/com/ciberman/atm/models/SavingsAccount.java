package com.ciberman.atm.models;

import java.math.BigDecimal;

public class SavingsAccount extends Account {


    public SavingsAccount(String cbu, BigDecimal balance) {
        super(cbu, balance);
    }

    @Override
    public String getName() {
        return "Caja Ahorro";
    }
}
