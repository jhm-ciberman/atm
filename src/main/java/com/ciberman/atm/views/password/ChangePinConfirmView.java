package com.ciberman.atm.views.password;

import com.ciberman.atm.views.BaseView;
import com.ciberman.atm.views.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.util.function.Consumer;

public class ChangePinConfirmView extends BaseView {

    @FXML
    private PasswordField pinField;

    private String previousPin = "";

    private final Consumer<String> onContinue;

    private final Runnable onCancel;


    public ChangePinConfirmView(Consumer<String> onContinue, Runnable onCancel) {
        this.onContinue = onContinue;
        this.onCancel = onCancel;
    }

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) {
        String pin = pinField.getText();
        this.onContinue.accept(pin);
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        this.onCancel.run();
    }

    @Override
    public String getViewName() {
        return Views.CHANGE_PASSWORD_CONFIRM;
    }
}
