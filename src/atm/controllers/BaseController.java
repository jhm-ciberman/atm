package atm.controllers;

import atm.App;
import atm.models.ATM;

public abstract class BaseController {

    App app;
    ATM atm;

    BaseController(App app) {
        this.app = app;
        this.atm = app.getAtm();
    }

    public abstract String getViewName();
}
