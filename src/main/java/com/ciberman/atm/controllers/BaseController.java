package com.ciberman.atm.controllers;

import com.ciberman.atm.Router;
import com.google.inject.Inject;

public abstract class BaseController {

    @Inject
    protected Router router;

    /**
     * Loads and show the view associated with the controller
     */
    public void andShowView() {
        router.showController(this);
    }

    public abstract String getViewName();
}
