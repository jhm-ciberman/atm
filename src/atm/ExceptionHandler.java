package atm;

import atm.exceptions.AuthenticationException;
import atm.exceptions.MaxLoginAttemptsReachedException;

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

        if (e instanceof MaxLoginAttemptsReachedException) {
            this.maxLoginAttemptsReachedException((MaxLoginAttemptsReachedException) e);
            return;
        }

        if (e instanceof AuthenticationException) {
            this.authenticationException((AuthenticationException) e);
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
                () -> router.handleAuthenticationException(e)
        );
    }
}
