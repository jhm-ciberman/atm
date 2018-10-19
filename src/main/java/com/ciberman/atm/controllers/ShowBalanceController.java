package com.ciberman.atm.controllers;

import com.ciberman.atm.Views;
import com.ciberman.atm.models.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.BigInteger;

public class ShowBalanceController extends BaseController {

    @FXML
    private Label balanceLabel;

    @FXML
    private Label accountNameLabel;

    private Account account;

    @FXML
    private void onCancelPressed() {
        router.showMainMenu();
    }

    @FXML
    private void initialize() {
        BigInteger balance = account.getBalance();
        String str = "$ " + balance.toString();
        balanceLabel.setText(str);
        accountNameLabel.setText(account.getName());
    }

    public ShowBalanceController setAccount(Account account) {
        this.account = account;
        return this;
    }

    @Override
    public String getViewName() {
        return Views.SHOW_BALANCE;
    }
}
