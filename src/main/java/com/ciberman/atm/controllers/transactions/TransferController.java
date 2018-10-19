package com.ciberman.atm.controllers.transactions;

import com.ciberman.atm.Views;
import com.ciberman.atm.models.Account;
import org.jetbrains.annotations.Nullable;


public class TransferController extends BaseTransferController {

    @Nullable
    private Account destinationAccount;

    @Nullable
    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setAccount(@Nullable Account account) {
        this.destinationAccount = account;
    }

    @Override
    public String getViewName() {
        return Views.TRANSFER_AMOUNT;
    }
}
