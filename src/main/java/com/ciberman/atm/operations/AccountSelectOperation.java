package com.ciberman.atm.operations;

import com.ciberman.atm.exceptions.NoAccountsException;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.account.Account;
import com.ciberman.atm.views.AccountSelectView;

import java.util.function.Consumer;

public class AccountSelectOperation extends Operation {

    public void start(Card card, Consumer<Account> onAccountSelect, Runnable onCancel) {

        if (card.getAccounts().isEmpty()) {
            this.showErrorAndThen(new NoAccountsException(), onCancel);
            return;
        }

        router.showController(new AccountSelectView(card, onAccountSelect, onCancel));
    }
}
