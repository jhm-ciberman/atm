package com.ciberman.atm.views.login;

import com.ciberman.atm.views.BaseView;
import com.ciberman.atm.views.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.math.BigInteger;
import java.util.function.Consumer;

public class EnterCardView extends BaseView {

    @FXML
    private TextField cardNumberField;

    private final Consumer<BigInteger> onCardNumber;

    public EnterCardView(Consumer<BigInteger> onCardNumber) {
        this.onCardNumber = onCardNumber;
    }


    @FXML
    public void onEnterCardPressed(ActionEvent event) {
        System.out.println("Card entered " + cardNumberField.getText());

        BigInteger number = new BigInteger(cardNumberField.getText());

        this.onCardNumber.accept(number);
    }

    @Override
    public String getViewName() {
        return Views.ENTER_CARD;
    }
}
