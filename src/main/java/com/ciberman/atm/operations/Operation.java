package com.ciberman.atm.operations;

import com.ciberman.atm.Router;
import com.ciberman.atm.exceptions.ATMError;
import com.ciberman.atm.views.ErrorView;
import com.google.inject.Inject;

public abstract class Operation {

    @Inject
    protected Router router;

    public void showErrorAndDie(ATMError e) {
        router.showController(new ErrorView(e, null));
    }

    public void showErrorAndThen(ATMError e, Runnable andThen) {
        router.showController(new ErrorView(e, andThen));
    }

}
