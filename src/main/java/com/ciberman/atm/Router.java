package com.ciberman.atm;

import com.ciberman.atm.controllers.*;
import com.ciberman.atm.services.Authenticatable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Represents the Application Router.
 * It has all the app routes, and redirects the requests between the controllers.
 */
public class Router {

    private Stage primaryStage;

    private App app;

    Router(App app) {
        this.app = app;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void gotoError(String errorTitle, String errorMessage, Runnable callback) {
        this.changeScene(new ErrorScreenController(app, errorTitle, errorMessage, callback));
    }

    public void gotoError(String errorTitle, String errorMessage) {
        this.changeScene(new ErrorScreenController(app, errorTitle, errorMessage));
    }

    public void gotoLogin(Authenticatable authenticatable) {
        this.changeScene(new LoginController(app, authenticatable));
    }

    public void gotoMainMenu() {
        this.changeScene(new MainMenuController(app));
    }
    public void gotoRetrieveCard() {
        this.changeScene(new RetrieveCardController(app));
    }
    public void gotoEnterCard() {
        this.changeScene(new EnterCardController(app));
    }



    /**
     * Changes the actual scene of the stage. (The content of the window)
     *
     * @param controller The controller to use as the active controller
     */
    public void changeScene(BaseController controller) {
        URL url = getClass().getResource("/views/" + controller.getViewName() + ".fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(controller);
        try {
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace(); // TODO: replace with a custom error view
        }

    }
}
