package com.ciberman.atm;

import com.ciberman.atm.controllers.ErrorScreenController;
import com.ciberman.atm.exceptions.ATMError;
import com.google.inject.Inject;

class ErrorHandler {

    @Inject
    Router router;

    /**
     * Handles the passed exception
     *
     * @param e The exception to handle
     */
    void handle(Throwable e) {
        if (e instanceof ATMError) {
            ErrorScreenController controller = router.goTo(Views.ERROR);
            controller.showError((ATMError) e);
            return;
        }

        Throwable cause = e.getCause();
        if (cause == null) {
            // Unknown error
            e.printStackTrace();
            ErrorScreenController controller = router.goTo(Views.ERROR);
            controller.showError(new ATMError(e));
            return;
        }

        this.handle(cause); // Recursive
    }
}
