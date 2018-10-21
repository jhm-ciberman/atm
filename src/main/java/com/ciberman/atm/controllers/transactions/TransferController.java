package com.ciberman.atm.controllers.transactions;

import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.SuccessController;
import com.ciberman.atm.models.Account;
import javafx.fxml.FXML;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;


public class TransferController extends BaseTransferController {

    @Nullable
    private Account destinationAccount;

    @FXML
    void onContinuePressed() {
        Account account = this.getAccountOrFail();

        BigDecimal amount = new BigDecimal(amountTextField.getText());

        this.checkAmountIsValid(amount);

        account.deposit(amount);

        router.makeController(SuccessController.class)
                .setSubtitle("La transación se realizó con éxito")
                .andShowView();
    }

    @Nullable
    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public TransferController setAccount(@Nullable Account account) {
        this.destinationAccount = account;
        return this;
    }

    @Override
    public String getViewName() {
        return Views.TRANSFER_AMOUNT;
    }
}
