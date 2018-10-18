package com.ciberman.atm.controllers;

import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.models.Account;
import javafx.fxml.FXML;

import java.math.BigInteger;

public class DepositController extends BaseTransferController {
    @FXML
    void onContinuePressed() throws UnauthorizedException {
        Account account = this.getAccountOrFail();

        BigInteger amount = new BigInteger(amountTextField.getText());
        account.deposit(amount);
    }
}
