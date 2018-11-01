package com.ciberman.atm.exceptions;

public class AccountNotFoundException extends ATMError {

    private final String cbu;

    public AccountNotFoundException(String cbu) {
        super("Cuenta no encontrada", "No se encontró una cuenta con ese CBU");
        this.cbu = cbu;
    }

    public String getCbu() {
        return cbu;
    }
}
