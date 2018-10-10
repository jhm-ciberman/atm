package com.ciberman.atm.controllers;

import com.ciberman.atm.Router;
import com.ciberman.atm.exceptions.ATMError;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ErrorScreenController {

    @Inject
    private Router router;

    @FXML
    private Label errorTitleLabel;
    @FXML
    private Label errorMessageLabel;
    @FXML
    private Button okButton;

    private String redirectTo;

    public void showError(ATMError e) {
        errorTitleLabel.setText(e.getTitle());
        errorMessageLabel.setText(e.getDescription());
        this.redirectTo = e.redirect();
        if (this.redirectTo.isEmpty()) {
            okButton.setVisible(false);
        }
    }

    @FXML
    public void onOkPressed(ActionEvent event) {
        if (!this.redirectTo.isEmpty()) {
            router.goTo(this.redirectTo);
        }
    }
}
