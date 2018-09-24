package com.ciberman.atm.controllers;

import com.ciberman.atm.App;
import javafx.concurrent.Task;
import javafx.fxml.FXML;

public class RetrieveCardController extends BaseController {

    private static final int WAITING_TIME = 8000;

    public RetrieveCardController(App app) {
        super(app);
    }

    @FXML
    void initialize() {
        Task<Void> sleeper = new Task<>() {
            @Override
            protected Void call() {
                try {
                    Thread.sleep(WAITING_TIME);
                } catch (InterruptedException ignored) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> app.getRouter().gotoEnterCard());
        new Thread(sleeper).start();
    }

    /**
     * @return Returns the name of the fxml file (without
     * extension) of the view related to this controller.
     */
    @Override
    public String getViewName() {
        return "retrieve_card";
    }
}
