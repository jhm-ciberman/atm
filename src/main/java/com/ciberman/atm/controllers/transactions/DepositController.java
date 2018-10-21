package com.ciberman.atm.controllers.transactions;

import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.SuccessController;
import com.ciberman.atm.models.Account;
import javafx.fxml.FXML;

import java.math.BigDecimal;

public class DepositController extends BaseTransferController {
    @FXML
    void onContinuePressed() {
        Account account = this.getAccountOrFail();

        BigDecimal amount = new BigDecimal(amountTextField.getText());

        this.checkAmountIsValid(amount);

        account.deposit(amount);

        router.makeController(SuccessController.class)
                .setSubtitle("El depósito se realizó con éxito")
                .andShowView();
    }

    @Override
    public String getViewName() {
        return Views.DEPOSIT_AMOUNT;
    }
}
