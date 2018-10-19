package com.ciberman.atm.controllers.password;

import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.BaseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

@SuppressWarnings("WeakerAccess")
public class ChangePasswordSuccessController extends BaseController {

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.showMainMenu();
    }

    @Override
    public String getViewName() {
        return Views.CHANGE_PASSWORD_SUCCESS;
    }
}
