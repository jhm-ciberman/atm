package com.ciberman.atm.operations;

import com.ciberman.atm.exceptions.AuthenticationException;
import com.ciberman.atm.exceptions.MaxLoginAttemptsReachedException;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.services.CardAuthenticator;
import com.ciberman.atm.views.login.EnterPinView;
import com.ciberman.atm.views.login.RetrieveCardView;
import com.google.inject.Inject;

import java.util.function.Consumer;

public class LoginOperation extends Operation {

    @Inject
    private CardAuthenticator cardAuthenticator;

    @Inject
    private EnterCardOperation enterCardOperation;

    public void start(Card card, Consumer<Card> andThen, Runnable onCancel) {
        router.showController(new EnterPinView(
                (pin) -> this.login(card, pin, andThen, onCancel),
                () -> router.showController(new RetrieveCardView(onCancel))
        ));
    }

    private void login(Card card, String pin, Consumer<Card> andThen, Runnable onCancel) {
        try {
            cardAuthenticator.doLogin(card, pin);
        } catch (AuthenticationException e) {
            this.showError(e, () -> this.start(card, andThen, onCancel));
        } catch (MaxLoginAttemptsReachedException e) {
            this.showError(e);
        }

        System.out.println("Login successful");
        andThen.accept(card);
    }
}
