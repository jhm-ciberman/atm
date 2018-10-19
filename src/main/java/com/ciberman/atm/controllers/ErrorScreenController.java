package com.ciberman.atm.controllers;

import com.ciberman.atm.Views;
import com.ciberman.atm.exceptions.ATMError;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ErrorScreenController extends BaseController {

    @FXML
    private Label errorTitleLabel;
    @FXML
    private Label errorMessageLabel;
    @FXML
    private Button okButton;

    private Class<? extends BaseController> redirectTo;

    private ATMError error;

    public ErrorScreenController setATMError(ATMError e) {
        errorTitleLabel.setText(e.getTitle());
        errorMessageLabel.setText(e.getDescription());
        this.redirectTo = e.redirect();
        if (this.redirectTo == null) {
            okButton.setVisible(false);
        }
        return this;
    }

    @FXML
    public void onOkPressed(ActionEvent event) {
        if (this.redirectTo != null) {
            router.showController(this.redirectTo);
        }
    }

    @Override
    public String getViewName() {
        return Views.ERROR;
    }
}
