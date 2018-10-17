package com.ciberman.atm;

import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.Nullable;

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
    @Nullable
    public <T> T goTo(String viewName) {
        if (primaryStage == null) {
            System.err.println("No primary stage defined");
            return null;
        }
        try {
            FXMLLoader loader = this.createLoaderForView(viewName);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            return loader.getController();
        } catch (Throwable e) {
            // Prevents infinite loops when an error happens when loading the error view
            if (!viewName.equals(ErrorHandler.errorView)) {
                this.handleError(e);
            } else {
                e.printStackTrace();
            }
        }
        return null;
    }

    private FXMLLoader createLoaderForView(String viewName) {
        URL url = getClass().getResource("/views/" + viewName + ".fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setControllerFactory(c -> this.injector.getInstance(c));
        return loader;
    }

    private void handleError(Throwable throwable) {
        this.injector.getInstance(ErrorHandler.class).handle(throwable);
    }
}
