package com.ciberman.atm.views.login;

import com.ciberman.atm.views.BaseView;
import com.ciberman.atm.views.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.util.function.Consumer;

/**
 * The controller for the PIN login screen.
 */
public class EnterPinView extends BaseView {

    @FXML
    private PasswordField pinField;

    private final Consumer<String> onPinEntered;

    private final Runnable onCancelPressed;

    public EnterPinView(Consumer<String> onPinEntered, Runnable onCancelPressed) {
        this.onPinEntered = onPinEntered;
        this.onCancelPressed = onCancelPressed;
    }

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) {
        String pin = pinField.getText();
        this.onPinEntered.accept(pin);
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        this.onCancelPressed.run();
    }

    @Override
    public String getViewName() {
        return Views.LOGIN;
    }
}
