package atm.controllers;

import atm.App;
import atm.models.ATM;

/**
 * Represents a generic Controller
 */
public abstract class BaseController {

    final App app;
    final ATM atm;

    BaseController(App app) {
        this.app = app;
        this.atm = app.getAtm();
    }

    /**
     * @return Returns the name of the fxml file (without
     * extension) of the view related to this controller.
     */
    public abstract String getViewName();
}
