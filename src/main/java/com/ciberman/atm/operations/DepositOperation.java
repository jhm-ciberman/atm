package com.ciberman.atm.operations;

import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.services.AccountService;
import com.ciberman.atm.views.StringInputView;
import com.ciberman.atm.views.StringInputViewData;
import com.ciberman.atm.views.SuccessView;
import com.google.inject.Inject;

public class DepositOperation extends Operation {

    @Inject
    private AccountSelectOperation accountSelectOperation;

    @Inject
    private AccountService accountService;

    public void start(Card card, Runnable onFinish) {
        this.accountSelectOperation.start(
                card,
                (account) -> this.showDepositScreen(account, onFinish),
                onFinish
        );
    }

    private void showDepositScreen(Account account, Runnable onFinish) {
        router.showController(new StringInputView(
                this.getViewData(),
                (amount) -> this.deposit(account, amount, onFinish),
                onFinish
        ));
    }

    private StringInputViewData getViewData() {
        StringInputViewData data = new StringInputViewData();
        data.setTitle("Depositar en la cuenta");
        data.setSubtitle("Ingrese el monto a depositar en pesos");
        data.setInfo("El monto debe ser múltiplo de $100");
        data.setButtonText("Monto");
        data.setButtonText("Depositar");
        return data;
    }

    private void deposit(Account account, String amountString, Runnable onFinish) {


        router.showController(new SuccessView(
                "Estupendo",
                "El dinero fue depositado correctamente",
                "Continuar",
                onFinish
        ));
    }

}
