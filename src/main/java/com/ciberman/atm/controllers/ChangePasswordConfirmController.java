package com.ciberman.atm.controllers;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.ciberman.atm.exceptions.ATMError;
import com.ciberman.atm.exceptions.PinsDontMatchException;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.services.Authenticatable;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ChangePasswordConfirmController {

    @Inject
    private AppContext appContext;

    @Inject
    private Router router;

    @FXML
    private PasswordField pinField;

    private String previousPin = "";

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) throws ATMError {
        Authenticatable authenticated = appContext.getAuthenticatedOrFail();

        String pin = pinField.getText();

        if (!previousPin.equals(pin)) {
            throw new PinsDontMatchException();
        }

        authenticated.updatePassword(pin);

        System.out.println("Password updated");
        router.goTo(Views.CHANGE_PASSWORD_SUCCESS);
    }

    void setPreviousPin(String pin) {
        previousPin = pin;
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.goTo(Views.MAIN_MENU);
    }
}
