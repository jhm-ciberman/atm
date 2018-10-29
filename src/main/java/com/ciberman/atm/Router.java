package com.ciberman.atm;

import com.ciberman.atm.views.BaseView;
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

    public void showController(BaseView controller) {
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
            e.printStackTrace();
        }
    }
}
