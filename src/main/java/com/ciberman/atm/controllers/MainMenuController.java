package com.ciberman.atm.controllers;

import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {

    @Inject
    private Router router;

    @FXML
    public void onExitPressed(ActionEvent e) {
        router.goTo(Views.RETRIEVE_CARD);
    }


    @FXML
    public void onPasswordChangePressed(ActionEvent e) {

    }

    @FXML
    public void onCheckBalancePressed(ActionEvent e) {

    }

    @FXML
    public void onRetrieveMoneyPressed(ActionEvent e) {

    }

    @FXML
    public void onDepositMoneyPressed(ActionEvent e) {

    }

    @FXML
    public void onTransferMoneyPressed(ActionEvent e) {

    }

    @FXML
    public void onCheckTransactionsPressed(ActionEvent e) {

    }

}
