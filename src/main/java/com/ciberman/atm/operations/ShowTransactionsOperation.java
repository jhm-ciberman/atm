package com.ciberman.atm.operations;

import com.ciberman.atm.models.Card;

public class ShowTransactionsOperation extends Operation {

    public void start(Card card, Runnable onFinish) {
        onFinish.run();
    }
}
