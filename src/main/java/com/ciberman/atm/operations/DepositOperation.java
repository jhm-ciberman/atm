package com.ciberman.atm.operations;

import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.views.SuccessView;
import com.ciberman.atm.views.transactions.WithdrawView;
import com.google.inject.Inject;

import java.math.BigDecimal;

public class DepositOperation extends Operation {

    @Inject
    private AccountSelectOperation accountSelectOperation;

    public void start(Card card, Runnable onFinish) {
        this.accountSelectOperation.start(
                card,
                (account) -> this.showDepositScreen(account, onFinish),
                onFinish
        );
    }

    private void showDepositScreen(Account account, Runnable onFinish) {
        router.showController(new WithdrawView(
                (amount) -> this.deposit(account, amount, onFinish),
                onFinish
        ));
    }


    private void deposit(Account account, BigDecimal amount, Runnable onFinish) {
        if (!this.amountIsValid(amount)) {

            return;
        }

        account.deposit(amount);

        router.showController(new SuccessView(
                "Retire el dinero",
                "El dinero aparecerá en la parte inferior del cajero",
                "Continuar",
                onFinish
        ));
    }

    protected boolean amountIsValid(BigDecimal amount) {
        return (!amount.remainder(new BigDecimal("100")).equals(BigDecimal.ZERO));
    }

}
