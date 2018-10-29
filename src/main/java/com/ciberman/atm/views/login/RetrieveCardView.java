package com.ciberman.atm.views.login;

import com.ciberman.atm.Views;
import com.ciberman.atm.views.BaseView;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class RetrieveCardView extends BaseView implements Initializable {

    private static final int WAITING_TIME = 8000;

    private final Runnable onContinue;

    public RetrieveCardView(Runnable onContinue) {
        this.onContinue = onContinue;
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        sleeper.setOnSucceeded(event -> this.onContinue.run());
        new Thread(sleeper).start();
    }

    @Override
    public String getViewName() {
        return Views.RETRIEVE_CARD;
    }


}
