package com.ciberman.atm.controllers.transactions;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.exceptions.InvalidAmountException;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.models.Account;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public abstract class BaseTransferController extends BaseController {
    @FXML
    protected TextField amountTextField;

    @Inject
    protected AppContext context;

    @Nullable
    protected Account account;

    private BigDecimal HUNDRED = new BigDecimal("100");

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

    protected void checkAmountIsValid(BigDecimal amount) {
        if (!amount.remainder(this.HUNDRED).equals(BigDecimal.ZERO)) {
            throw new InvalidAmountException(WithdrawController.class);
        }
    }

    @Nullable
    public Account getAccount() {
        return account;
    }

    public BaseTransferController setAccount(@Nullable Account account) {
        this.account = account;
        return this;
    }

}
