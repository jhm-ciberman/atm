package com.ciberman.atm.operations;

import com.ciberman.atm.models.Card;
import com.ciberman.atm.views.MainMenuOption;
import com.ciberman.atm.views.MainMenuView;
import com.google.inject.Inject;

public class MainMenuOperation extends Operation {

    @Inject
    private WithdrawOperation withdrawOperation;

    @Inject
    private ChangePinOperation changePinOperation;

    @Inject
    private TransferOperation transferOperation;

    @Inject
    private DepositOperation depositOperation;

    public void start(Card card, Runnable onFinish) {
        String name = card.getOwner().getName();
        router.showController(new MainMenuView(
                "Bienvenido " + name,
                option -> handleMainMenuOption(card, option, onFinish)
        ));
    }

    public void handleMainMenuOption(Card card, MainMenuOption option, Runnable onFinish) {
        switch (option) {
            case CHANGE_PIN:
                changePinOperation.start(card, () -> this.start(card, onFinish));
                break;
            case WITHDRAW:
                withdrawOperation.start(card, () -> this.start(card, onFinish));
                break;
            case DEPOSIT:
                depositOperation.start(card, () -> this.start(card, onFinish));
                break;
            case TRANSFER:
                transferOperation.start(card, () -> this.start(card, onFinish));
                break;
            case SHOW_BALANCE:
                break;
            case SHOW_TRANSACTIONS:
                break;
            case END:
                onFinish.run();
                break;
        }
    }
}
