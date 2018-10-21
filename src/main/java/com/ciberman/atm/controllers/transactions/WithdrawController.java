package com.ciberman.atm.controllers.transactions;

import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.SuccessController;
import com.ciberman.atm.models.Account;
import javafx.fxml.FXML;

import java.math.BigDecimal;

public class WithdrawController extends BaseTransferController {

    @FXML
    void onContinuePressed() {
        Account account = this.getAccountOrFail();

        BigDecimal amount = new BigDecimal(amountTextField.getText());

        this.checkAmountIsValid(amount);

        System.out.println("Retirando");

        account.withdraw(amount);

        System.out.println("End Retirando");

        router.makeController(SuccessController.class)
                .setTitle("Retire el dinero")
                .setSubtitle("El dinero aparecerá en la parte inferior del cajero")
                .andShowView();
    }

    @Override
    public String getViewName() {
        return Views.WITHDRAW_AMOUNT;
    }
}
