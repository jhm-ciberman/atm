package com.ciberman.atm.operations;

import com.ciberman.atm.exceptions.InvalidCardException;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.services.CardFinder;
import com.ciberman.atm.views.login.EnterCardView;
import com.ciberman.atm.views.login.RetrieveCardView;
import com.google.inject.Inject;

import java.util.function.Consumer;

public class EnterCardOperation extends Operation {

    @Inject
    private CardFinder cardFinder;

    public void start(Consumer<Card> andThen) {
        router.showController(new EnterCardView((cardNumber) -> {
            try {
                Card card = cardFinder.findCard(cardNumber);
                andThen.accept(card);
            } catch (InvalidCardException e) {
                this.showError(
                        new InvalidCardException(cardNumber),
                        () -> this.retrieveCard(andThen)
                );
            }
        }));
    }

    private void retrieveCard(Consumer<Card> andThen) {
        router.showController(new RetrieveCardView(
                () -> this.start(andThen)
        ));
    }

}
