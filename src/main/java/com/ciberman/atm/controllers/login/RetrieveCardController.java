package com.ciberman.atm.controllers.login;

import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.google.inject.Inject;
import javafx.concurrent.Task;
import javafx.fxml.FXML;

public class RetrieveCardController {

    @Inject
    private Router router;

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
        sleeper.setOnSucceeded(event -> router.goTo(Views.ENTER_CARD));
        new Thread(sleeper).start();
    }
}
