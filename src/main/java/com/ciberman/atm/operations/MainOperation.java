package com.ciberman.atm.operations;

import com.ciberman.atm.Router;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.views.login.RetrieveCardView;
import com.google.inject.Inject;

public class MainOperation extends Operation {

    @Inject
    protected Router router;

    @Inject
    private LoginOperation loginOperation;

    @Inject
    private EnterCardOperation enterCardOperation;

    @Inject
    private MainMenuOperation mainMenuOperation;

    public void start() {
        this.showLogin();
    }

    private void showLogin() {
        this.enterCardOperation.start(
                (card) -> this.loginOperation.start(card, this::showMainMenu, this::showLogin)
        );
    }

    private void showMainMenu(Card card) {
        this.mainMenuOperation.start(
                card,
                () -> router.showController(new RetrieveCardView(this::start))
        );
    }

}
