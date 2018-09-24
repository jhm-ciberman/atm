package com.ciberman.atm.controllers;

import com.ciberman.atm.App;
import com.ciberman.atm.services.Authenticatable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ChangePasswordController extends BaseController {

    private Authenticatable authenticatable;

    @FXML
    private PasswordField pinField;

    public ChangePasswordController(App app, Authenticatable authenticatable) {
        super(app);
        this.authenticatable = authenticatable;
    }

    /**
     * @return Returns the name of the fxml file (without
     * extension) of the view related to this controller.
     */
    @Override
    public String getViewName() {
        return "change_password";
    }

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) {
        authenticatable.updatePassword(pinField.getText());
        System.out.println("Password updated");
        app.getRouter().gotoMainMenu();
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        app.getRouter().gotoMainMenu();
    }
}
