package com.ciberman.atm.controllers.password;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.exceptions.ATMError;
import com.ciberman.atm.exceptions.PinsDontMatchException;
import com.ciberman.atm.services.Authenticatable;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ChangePasswordConfirmController extends BaseController {

    @Inject
    private AppContext appContext;

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
        router.makeController(ChangePasswordSuccessController.class).andShowView();
    }

    ChangePasswordConfirmController setPreviousPin(String pin) {
        previousPin = pin;
        return this;
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.showMainMenu();
    }

    @Override
    public String getViewName() {
        return Views.CHANGE_PASSWORD_CONFIRM;
    }
}
