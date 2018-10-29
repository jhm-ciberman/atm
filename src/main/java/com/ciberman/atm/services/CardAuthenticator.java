package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.AuthenticationException;
import com.ciberman.atm.exceptions.MaxLoginAttemptsReachedException;
import com.ciberman.atm.models.Card;
import com.google.inject.Inject;

public class CardAuthenticator {

    @Inject
    private AuthService auth;

    public void doLogin(Card card, String pin) throws MaxLoginAttemptsReachedException, AuthenticationException {
        if (auth.hasTooManyAttempts(card)) {
            throw new MaxLoginAttemptsReachedException();
        }

        if (!auth.check(card, pin)) {
            card.failLogin();
            throw new AuthenticationException(card);
        }

        card.resetLoginAttempts();
    }
}
