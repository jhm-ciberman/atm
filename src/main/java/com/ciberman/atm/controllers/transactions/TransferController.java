package com.ciberman.atm.controllers.transactions;

import com.ciberman.atm.models.Account;
import javafx.fxml.FXML;
import org.jetbrains.annotations.Nullable;


public class TransferController extends BaseTransferController {

    @Nullable
    private Account destinationAccount;

    @FXML
    void onContinuePressed() {

    }

    @Nullable
    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setAccount(@Nullable Account account) {
        this.destinationAccount = account;
    }

}
