package com.ciberman.atm.operations;

import com.ciberman.atm.Router;
import com.ciberman.atm.exceptions.PinsDontMatchException;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.views.ErrorView;
import com.ciberman.atm.views.SuccessView;
import com.ciberman.atm.views.password.ChangePinConfirmView;
import com.ciberman.atm.views.password.ChangePinView;
import com.google.inject.Inject;

public class ChangePinOperation {

    @Inject
    private Router router;

    public void start(Card card, Runnable onFinish) {
        router.showController(new ChangePinView(
                (pin) -> this.showConfirmationScreen(card, pin, onFinish),
                onFinish
        ));
    }

    private void showConfirmationScreen(Card card, String previousPin, Runnable onFinish) {
        router.showController(new ChangePinConfirmView(
                (pin) -> this.changePin(card, previousPin, pin, onFinish),
                onFinish
        ));
    }

    private void changePin(Card card, String previousPin, String pin, Runnable onFinish) {

        if (!previousPin.equals(pin)) {
            router.showController(new ErrorView(
                    new PinsDontMatchException(),
                    () -> this.start(card, onFinish)
            ));
            return;
        }

        card.updatePassword(pin);

        System.out.println("Password updated");

        router.showController(new SuccessView(
                "Estupendo!",
                "El pin fue cambiado correctamente",
                "Continuar",
                onFinish
        ));
    }


}
