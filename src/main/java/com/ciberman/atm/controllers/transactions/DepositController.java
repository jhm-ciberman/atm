package com.ciberman.atm.controllers.transactions;

import com.ciberman.atm.models.Account;
import javafx.fxml.FXML;

import java.math.BigInteger;

public class DepositController extends BaseTransferController {
    @FXML
    void onContinuePressed() {
        Account account = this.getAccountOrFail();

        BigInteger amount = new BigInteger(amountTextField.getText());
        account.deposit(amount);
    }
}
