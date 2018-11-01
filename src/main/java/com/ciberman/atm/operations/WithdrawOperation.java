package com.ciberman.atm.operations;

import com.ciberman.atm.exceptions.InvalidOperationException;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.account.Account;
import com.ciberman.atm.services.AccountService;
import com.ciberman.atm.views.StringInputView;
import com.ciberman.atm.views.StringInputViewData;
import com.ciberman.atm.views.SuccessView;
import com.google.inject.Inject;


public class WithdrawOperation extends Operation {

    @Inject
    private AccountSelectOperation accountSelectOperation;

    @Inject
    private AccountService accountService;

    public void start(Card card, Runnable onFinish) {
        this.accountSelectOperation.start(
                card,
                (account) -> this.showWithdrawScreen(account, onFinish),
                onFinish
        );
    }

    private void showWithdrawScreen(Account account, Runnable onFinish) {
        router.showController(new StringInputView(
                this.getIntegerInputViewData(),
                (amount) -> this.withdraw(account, amount, onFinish),
                onFinish
        ));
    }

    private StringInputViewData getIntegerInputViewData() {
        StringInputViewData data = new StringInputViewData();
        data.setTitle("Retirar de la cuenta");
        data.setSubtitle("Ingrese el monto a retirar en pesos");
        data.setInfo("El monto debe ser múltiplo de $100");
        data.setButtonText("Monto");
        data.setButtonText("Retirar");
        return data;
    }

    private void withdraw(Account account, String amount, Runnable onFinish) {

        try {
            accountService.withdraw(account, amount);

            router.showController(new SuccessView(
                    "Retire el dinero",
                    "El dinero aparecerá en la parte inferior del cajero",
                    "Continuar",
                    onFinish
            ));

        } catch (InvalidOperationException e) {
            this.showErrorAndThen(e, () -> this.showWithdrawScreen(account, onFinish));
        }
    }
}
