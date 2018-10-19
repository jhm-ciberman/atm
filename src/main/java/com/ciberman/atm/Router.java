package com.ciberman.atm;

import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.controllers.MainMenuController;
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
    public static Stage primaryStage;

    public <T extends BaseController> T makeController(Class<T> controllerClass) {
        return injector.getInstance(controllerClass);
    }

    public void showController(BaseController controller) {
        if (primaryStage == null) {
            System.err.println("No primary stage defined");
            return;
        }
        String viewName = controller.getViewName();
        try {
            URL url = getClass().getResource("/views/" + viewName + ".fxml");
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(controller);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Throwable e) {
            // Prevents infinite loops when an error happens when loading the error view
            if (!viewName.equals(ErrorHandler.errorView)) {
                this.handleError(e);
            } else {
                e.printStackTrace();
            }
        }
    }


    public void showMainMenu() {
        this.makeController(MainMenuController.class).andShowView();
    }

    public <T extends BaseController> void showController(Class<T> controllerClass) {
        this.makeController(controllerClass).andShowView();
    }

    private void handleError(Throwable throwable) {
        this.injector.getInstance(ErrorHandler.class).handle(throwable);

    }

}
