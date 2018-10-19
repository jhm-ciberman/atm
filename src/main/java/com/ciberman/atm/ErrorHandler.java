package com.ciberman.atm;

import com.ciberman.atm.controllers.ErrorScreenController;
import com.ciberman.atm.exceptions.ATMError;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ErrorHandler {

    public final static String errorView = Views.ERROR;

    @Inject
    private Injector injector;

    @Inject
    private Router router;

    /**
     * Handles the passed exception
     *
     * @param e The exception to handle
     */
    public void handle(Throwable e) {
        if (e instanceof ATMError) {
            router.makeController(ErrorScreenController.class)
                    .setATMError((ATMError) e)
                    .andShowView();
            return;
        }

        Throwable cause = e.getCause();
        if (cause == null) {
            // Unknown error
            e.printStackTrace();
            router.makeController(ErrorScreenController.class)
                    .setATMError(new ATMError(e))
                    .andShowView();
            return;
        }

        this.handle(cause); // Recursive
    }
}
