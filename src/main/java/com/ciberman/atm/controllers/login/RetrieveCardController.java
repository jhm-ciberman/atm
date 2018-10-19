package com.ciberman.atm.controllers.login;

import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.BaseController;
import javafx.concurrent.Task;
import javafx.fxml.FXML;

public class RetrieveCardController extends BaseController {

    private static final int WAITING_TIME = 8000;

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
        sleeper.setOnSucceeded(event -> router.makeController(EnterCardController.class).andShowView());
        new Thread(sleeper).start();
    }

    @Override
    public String getViewName() {
        return Views.RETRIEVE_CARD;
    }
}
