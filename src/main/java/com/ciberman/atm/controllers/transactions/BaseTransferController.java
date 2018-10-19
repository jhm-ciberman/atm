package com.ciberman.atm.controllers.transactions;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.models.Account;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.Nullable;

public abstract class BaseTransferController extends BaseController {
    @FXML
    protected TextField amountTextField;

    @Inject
    protected AppContext context;

    @Nullable
    protected Account account;

    @FXML
    public void onCancelPressed() {
        router.showMainMenu();
    }

    protected Account getAccountOrFail() {
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
