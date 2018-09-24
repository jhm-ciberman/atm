package com.ciberman.atm;

import com.ciberman.atm.exceptions.AuthenticationException;
import com.ciberman.atm.exceptions.InvalidCardException;
import com.ciberman.atm.exceptions.MaxLoginAttemptsReachedException;

class ExceptionHandler {

    private Router router;

    ExceptionHandler(Router router) {
        this.router = router;
    }

    /**
     * Handles the passed exception
     *
     * @param e The exception to handle
     */
    void handle(Throwable e) {
        if (this.tryToHandle(e)) {
            return;
        }

        Throwable cause = e.getCause();
        if (cause == null) {
            // Unknown error
            e.printStackTrace();
            router.gotoError("No se pudo completar la operación", e.getMessage());
            return;
        }

        handle(cause); // Recursive


    }


    /**
     * Tries to handle the passed exception
     *
     * @param e The exception
     * @return True if the exception is handled. False if not
     */
    private boolean tryToHandle(Throwable e) {
        if (e instanceof MaxLoginAttemptsReachedException) {
            this.maxLoginAttemptsReachedException((MaxLoginAttemptsReachedException) e);
            return true;
        }

        if (e instanceof AuthenticationException) {
            this.authenticationException((AuthenticationException) e);
            return true;
        }

        if (e instanceof InvalidCardException) {
            this.invalidCardException((InvalidCardException) e);
            return true;
        }

        return false;
    }

    private void maxLoginAttemptsReachedException(MaxLoginAttemptsReachedException e) {
        router.gotoError(
                "Tarjeta retenida",
                "Ha ingresado un PIN incorrecto demasiadas veces. Consulte en la sucursal de su banco más cercana."
        );
    }

    private void authenticationException(AuthenticationException e) {
        router.gotoError(
                "El pin ingresado es incorrecto",
                "Intente nuevamente",
                () -> router.gotoLogin(e.getAuthenticatable())
        );
    }

    private void invalidCardException(InvalidCardException e) {
        router.gotoError(
                "La tarjeta ingresada no es válida",
                "Compruebe que la tarjeta corresponde a un banco aderhido a la red del Banco de la Plaza.",
                () -> router.gotoRetrieveCard()
        );
    }
}
