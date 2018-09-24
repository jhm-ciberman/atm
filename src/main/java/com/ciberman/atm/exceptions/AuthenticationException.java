package com.ciberman.atm.exceptions;

import com.ciberman.atm.services.Authenticatable;

public class AuthenticationException extends Exception {
    private Authenticatable authenticatable;

    public AuthenticationException(Authenticatable authenticatable) {

        this.authenticatable = authenticatable;
    }

    public Authenticatable getAuthenticatable() {
        return authenticatable;
    }
}
