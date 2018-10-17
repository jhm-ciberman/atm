package com.ciberman.atm.controllers;

import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.ciberman.atm.models.Account;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.BigInteger;

public class ShowBalanceController {

    @FXML
    private Label balanceLabel;

    @FXML
    private Label accountNameLabel;

    @Inject
    private Router router;

    @FXML
    private void onCancelPressed() {
        router.goTo(Views.MAIN_MENU);
    }

    public void showBalanceFor(Account account) {
        BigInteger balance = account.getBalance();
        String str = "$ " + balance.toString();
        balanceLabel.setText(str);
        accountNameLabel.setText(account.getName());
    }

}
