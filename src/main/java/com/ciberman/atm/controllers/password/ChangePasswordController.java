package com.ciberman.atm.controllers.password;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.controllers.MainMenuController;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ChangePasswordController extends BaseController {

    @Inject
    private AppContext appContext;

    @FXML
    private PasswordField pinField;

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) throws UnauthorizedException {
        appContext.getAuthenticatedOrFail();

        String pin = pinField.getText();

        router.makeController(ChangePasswordConfirmController.class)
                .setPreviousPin(pin)
                .andShowView();
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.makeController(MainMenuController.class).andShowView();
    }

    @Override
    public String getViewName() {
        return Views.CHANGE_PASSWORD;
    }
}
