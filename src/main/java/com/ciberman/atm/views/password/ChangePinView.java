package com.ciberman.atm.views.password;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Views;
import com.ciberman.atm.views.BaseView;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.util.function.Consumer;

public class ChangePinView extends BaseView {

    @Inject
    private AppContext appContext;

    @FXML
    private PasswordField pinField;

    private final Consumer<String> onContinue;

    private final Runnable onCancel;


    public ChangePinView(Consumer<String> onContinue, Runnable onCancel) {
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
        return Views.CHANGE_PASSWORD;
    }
}
