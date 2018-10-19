package com.ciberman.atm.controllers.login;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.exceptions.AuthenticationException;
import com.ciberman.atm.exceptions.MaxLoginAttemptsReachedException;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.services.AuthService;
import com.ciberman.atm.services.Authenticatable;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

/**
 * The controller for the PIN login screen.
 */
public class LoginController extends BaseController {

    @Inject
    private AuthService auth;

    @Inject
    private AppContext appContext;

    @FXML
    private PasswordField pinField;

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) throws AuthenticationException, MaxLoginAttemptsReachedException, UnauthorizedException {
        Authenticatable authenticatable = appContext.getAuthenticatable();
        String pin = pinField.getText();

        if (authenticatable == null) {
            throw new UnauthorizedException();
        }

        if (auth.hasTooManyAttempts(authenticatable)) {
            throw new MaxLoginAttemptsReachedException();
        }

        if (!auth.check(authenticatable, pin)) {
            authenticatable.failLogin();
            throw new AuthenticationException(authenticatable);
        }

        authenticatable.resetLoginAttempts();
        appContext.setAuthenticated(authenticatable);
        System.out.println("Login successful");
        router.showMainMenu();
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.makeController(RetrieveCardController.class).andShowView();
    }

    @Override
    public String getViewName() {
        return Views.LOGIN;
    }
}
