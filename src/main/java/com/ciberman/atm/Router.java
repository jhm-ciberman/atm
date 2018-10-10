package com.ciberman.atm;

import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URL;

public class Router {

    @Inject
    Injector injector;

    @Nullable
    static Stage primaryStage;

    /**
     * Loads a new view. Returns the associated controller.
     * @param viewName The view fxml file name (without extension)
     * @param <T> The controller
     * @return The controller
     */
    public <T> T goTo( String viewName) {
        if (primaryStage == null) {
            System.err.println("No primary stage defined");
            return null;
        }
        try {
            URL url = getClass().getResource("/views/" + viewName + ".fxml");
            FXMLLoader loader = new FXMLLoader(url);
            loader.setControllerFactory(c -> this.injector.getInstance(c));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
