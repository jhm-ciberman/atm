package com.ciberman.atm.operations;

import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.services.AccountService;
import com.ciberman.atm.views.StringInputViewData;
import com.ciberman.atm.views.SuccessView;
import com.google.inject.Inject;

public class TransferOperation extends Operation {

    @Inject
    EnterStringOperation enterStringOperation;
    @Inject
    private AccountSelectOperation accountSelectOperation;
    @Inject
    private EnterCBUOperation enterCBUOperation;
    @Inject
    private AccountService accountService;

    public void start(Card card, Runnable onFinish) {
        this.accountSelectOperation.start(
                card,
                (sourceAccount) -> this.getDestination(sourceAccount, onFinish),
                onFinish
        );
    }

    private void getDestination(Account sourceAccount, Runnable onFinish) {
        this.enterCBUOperation.start(
                destinationAccount -> this.getAmount(sourceAccount, destinationAccount, onFinish),
                onFinish
        );
    }

    private void getAmount(Account sourceAccount, Account destinationAccount, Runnable onFinish) {
        StringInputViewData data = this.getTransferAmountViewData();
        this.enterStringOperation.start(
                data,
                (amount) -> this.transfer(sourceAccount, destinationAccount, amount, onFinish),
                onFinish
        );
    }

    private StringInputViewData getTransferAmountViewData() {
        StringInputViewData data = new StringInputViewData();
        data.setTitle("Transferir a otra cuenta");
        data.setSubtitle("Ingrese el monto a transferir en pesos");
        data.setInfo("El monto debe ser múltiplo de $100");
        data.setButtonText("Monto");
        data.setButtonText("Transferir");
        return data;
    }

    private void transfer(Account sourceAccount, Account destinationAccount, String amount, Runnable onFinish) {
        accountService.transfer(sourceAccount, destinationAccount, amount);

        router.showController(new SuccessView(
                "Transferencia correcta",
                "La transferencia se ha realizado correctamente",
                "Volver al menu",
                onFinish
        ));
    }
}
