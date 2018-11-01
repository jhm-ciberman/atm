package com.ciberman.atm.operations;

import com.ciberman.atm.models.Card;
import com.ciberman.atm.views.ShowMovementsView;
import com.google.inject.Inject;

public class ShowTransactionsOperation extends Operation {

    @Inject
    private AccountSelectOperation accountSelectOperation;

    public void start(Card card, Runnable onFinish) {

        this.accountSelectOperation.start(
                card,
                account -> router.showController(new ShowMovementsView(account, onFinish)),
                onFinish
        );
    }
}
