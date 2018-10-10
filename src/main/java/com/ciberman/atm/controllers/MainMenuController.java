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
        router.goTo(Views.CHANGE_PASSWORD);
    }

    @FXML
    public void onCheckBalancePressed(ActionEvent e) {
        router.goTo(Views.CHANGE_PASSWORD);
    }

    @FXML
    public void onRetrieveMoneyPressed(ActionEvent e) {
        router.goTo(Views.CHANGE_PASSWORD);
    }

    @FXML
    public void onDepositMoneyPressed(ActionEvent e) {
        router.goTo(Views.CHANGE_PASSWORD);
    }

    @FXML
    public void onTransferMoneyPressed(ActionEvent e) {
        router.goTo(Views.CHANGE_PASSWORD);
    }

    @FXML
    public void onCheckTransactionsPressed(ActionEvent e) {
        router.goTo(Views.CHANGE_PASSWORD);
    }

}
