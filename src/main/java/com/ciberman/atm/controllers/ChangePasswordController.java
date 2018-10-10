package com.ciberman.atm.controllers;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.ciberman.atm.exceptions.AuthenticationException;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.services.Authenticatable;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ChangePasswordController {

    private AppContext appContext;

    @Inject
    private Router router;

    @FXML
    private PasswordField pinField;

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) throws UnauthorizedException {
        Authenticatable authenticated = appContext.getAuthenticated();
        if (authenticated == null) {
            throw new UnauthorizedException();
        }
        authenticated.updatePassword(pinField.getText());
        System.out.println("Password updated");
        router.goTo(Views.MAIN_MENU);
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.goTo(Views.MAIN_MENU);
    }
}
