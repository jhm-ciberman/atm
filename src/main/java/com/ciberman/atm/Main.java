package com.ciberman.atm;

import com.ciberman.atm.exceptions.ATMError;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int STAGE_WIDTH = 800;
    private static final int STAGE_HEIGHT = 600;

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


        Router.primaryStage = primaryStage;

        primaryStage.setWidth(STAGE_WIDTH);
        primaryStage.setHeight(STAGE_HEIGHT);
        primaryStage.setTitle("Banco FASTA");

        Injector injector = Guice.createInjector(new AtmModule());

        Thread.setDefaultUncaughtExceptionHandler((Thread thread, Throwable throwable) -> {
            injector.getInstance(ErrorHandler.class).handle(throwable);
        });

        Router router = injector.getInstance(Router.class);
        router.goTo(Views.ENTER_CARD);

        primaryStage.show();
    }


}
