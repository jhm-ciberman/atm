package com.ciberman.atm.controllers;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.ciberman.atm.exceptions.ATMError;
import com.ciberman.atm.exceptions.PinsDontMatchException;
import com.ciberman.atm.services.Authenticatable;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ChangePasswordSuccessController {

    @Inject
    private Router router;

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.goTo(Views.MAIN_MENU);
    }
}
