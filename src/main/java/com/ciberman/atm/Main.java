package com.ciberman.atm;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Entry point
     *
     * @param args The application startup arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method is called by JavaFX when the app is initialized
     *
     * @param primaryStage The primary stage object (The main window)
     * @throws Exception Any exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        new App(primaryStage);
    }
}
