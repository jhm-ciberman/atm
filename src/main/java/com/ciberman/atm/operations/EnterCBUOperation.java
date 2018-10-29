package com.ciberman.atm.operations;

import com.ciberman.atm.exceptions.AccountNotFoundException;
import com.ciberman.atm.models.Account;
import com.ciberman.atm.services.AccountFinder;
import com.ciberman.atm.views.StringInputView;
import com.ciberman.atm.views.StringInputViewData;
import com.google.inject.Inject;

import java.util.function.Consumer;

public class EnterCBUOperation extends Operation {

    @Inject
    private AccountFinder accountFinder;

    public void start(Consumer<Account> onAccount, Runnable onCancel) {
        router.showController(new StringInputView(
                this.getCBUViewData(),
                (cbu) -> this.findAccount(cbu, onAccount, onCancel),
                onCancel
        ));
    }

    private void findAccount(String cbu, Consumer<Account> onAccount, Runnable onCancel) {
        try {
            Account account = accountFinder.findAccount(cbu);
            onAccount.accept(account);
        } catch (AccountNotFoundException e) {
            this.showError(e, () -> {
                this.start(onAccount, onCancel);
            });
        }

    }

    private StringInputViewData getCBUViewData() {
        StringInputViewData data = new StringInputViewData();
        data.setTitle("Depositar dinero");
        data.setSubtitle("Ingrese el CBU de la cuenta a la cual quiere depositar");
        data.setInfo("El número de CBU tiene 22 dígitos");
        data.setButtonText("CBU");
        data.setButtonText("Depositar");
        return data;
    }
}
