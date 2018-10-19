package com.ciberman.atm.controllers.password;

import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

@SuppressWarnings("WeakerAccess")
public class ChangePasswordSuccessController {

    @Inject
    private Router router;

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.goTo(Views.MAIN_MENU);
    }
}
