package com.ciberman.atm.controllers;

import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.models.Account;
import javafx.fxml.FXML;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class TransferController extends BaseTransferController {

    @Nullable
    private Account destinationAccount;

    @FXML
    void onContinuePressed() {

    }

    @NotNull
    protected Account getDestinationAccountOrFail() throws UnauthorizedException {
        return this.destinationAccount;
    }

    @Nullable
    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setAccount(@Nullable Account account) {
        this.destinationAccount = account;
    }

}
