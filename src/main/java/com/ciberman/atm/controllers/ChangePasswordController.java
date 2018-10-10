package com.ciberman.atm.controllers;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ChangePasswordController {

    @Inject
    private AppContext appContext;

    @Inject
    private Router router;

    @FXML
    private PasswordField pinField;

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) throws UnauthorizedException {
        appContext.getAuthenticatedOrFail();

        String pin = pinField.getText();

        ChangePasswordConfirmController controller = router.goTo(Views.CHANGE_PASSWORD_CONFIRM);
        controller.setPreviousPin(pin);
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.goTo(Views.MAIN_MENU);
    }
}
