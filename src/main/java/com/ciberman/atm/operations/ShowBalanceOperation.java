package com.ciberman.atm.operations;

import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.account.Account;
import com.ciberman.atm.views.ShowBalanceView;
import com.google.inject.Inject;

public class ShowBalanceOperation extends Operation {

    @Inject
    private AccountSelectOperation accountSelectOperation;

    public void start(Card card, Runnable onFinish) {
        this.accountSelectOperation.start(
                card,
                (account) -> this.showBalance(account, onFinish),
                onFinish
        );
    }

    private void showBalance(Account account, Runnable onFinish) {
        router.showController(new ShowBalanceView(account, onFinish));
    }
}
