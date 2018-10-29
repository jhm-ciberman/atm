package com.ciberman.atm.operations;

import com.ciberman.atm.exceptions.InvalidOperationException;
import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.views.SuccessView;
import com.ciberman.atm.views.transactions.WithdrawView;
import com.google.inject.Inject;

import java.math.BigDecimal;

public class WithdrawOperation extends Operation {

    @Inject
    private AccountSelectOperation accountSelectOperation;

    public void start(Card card, Runnable onFinish) {
        this.accountSelectOperation.start(
                card,
                (account) -> this.showWithdrawScreen(account, onFinish),
                onFinish
        );
    }

    private void showWithdrawScreen(Account account, Runnable onFinish) {
        router.showController(new WithdrawView(
                (amount) -> this.withdraw(account, amount, onFinish),
                onFinish
        ));
    }

    private void withdraw(Account account, BigDecimal amount, Runnable onFinish) {
        if (!this.amountIsValid(amount)) {

            return;
        }

        try {
            account.withdraw(amount);
        } catch (InvalidOperationException e) {
            e.printStackTrace();
        }

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
