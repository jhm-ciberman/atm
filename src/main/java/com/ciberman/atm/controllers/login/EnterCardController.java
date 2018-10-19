package com.ciberman.atm.controllers.login;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.exceptions.InvalidCardException;
import com.ciberman.atm.models.ATM;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.services.ATMProvider;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.math.BigInteger;

public class EnterCardController extends BaseController {

    @FXML
    private TextField cardNumberField;

    @Inject
    private AppContext appContext;

    @Inject
    private ATMProvider atmProvider;

    @FXML
    public void onEnterCardPressed(ActionEvent event) throws InvalidCardException {
        System.out.println("Card entered " + cardNumberField.getText());

        BigInteger number = new BigInteger(cardNumberField.getText());

        ATM atm = atmProvider.getAtm();
        Card card = atm.cards.stream()
                .filter(e -> e.getNumber().equals(number))
                .findFirst()
                .orElse(null);

        if (card != null) {
            appContext.setAuthenticatable(card);
            router.showController(LoginController.class);
        } else {
            throw new InvalidCardException(number);
        }

    }

    @Override
    public String getViewName() {
        return Views.ENTER_CARD;
    }
}
