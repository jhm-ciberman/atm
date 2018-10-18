package com.ciberman.atm.controllers;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.models.Account;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.Nullable;

public abstract class BaseTransferController {
    @FXML
    protected TextField amountTextField;

    @Inject
    protected Router router;

    @Inject
    protected AppContext context;

    @Nullable
    protected Account account;

    @FXML
    public void onCancelPressed() {
        router.goTo(Views.MAIN_MENU);
    }

    @FXML
    void onContinuePressed() throws UnauthorizedException {

    }

    protected Account getAccountOrFail() throws UnauthorizedException {
        if (this.account == null) {
            throw new UnauthorizedException();
        }
        return this.account;
    }

    @Nullable
    public Account getAccount() {
        return account;
    }

    public void setAccount(@Nullable Account account) {
        this.account = account;
    }

}
