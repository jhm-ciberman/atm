package atm;

import atm.controllers.*;
import atm.exceptions.AuthenticationException;
import atm.models.Card;
import atm.services.Authenticatable;
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

    Router(Stage primaryStage, App app) {
        this.primaryStage = primaryStage;
        this.app = app;
    }

    public void gotoError(String errorTitle, String errorMessage, Runnable callback) {
        this.changeScene(new ErrorScreenController(app, errorTitle, errorMessage, callback));
    }

    public void gotoError(String errorTitle, String errorMessage) {
        this.changeScene(new ErrorScreenController(app, errorTitle, errorMessage));
    }

    public void gotoLogin(Card card) {
        this.changeScene(new LoginController(app, card));
    }

    public void gotoEnterCard() {
        this.changeScene(new EnterCardController(app));
    }

    public void gotoMainMenu() {
        this.changeScene(new MainMenuController(app));
    }

    public void handleAuthenticationException(AuthenticationException e) {
        Authenticatable authenticatable = (e).getAuthenticatable();
        if (authenticatable instanceof Card) {
            this.gotoLogin((Card) authenticatable);
        }
    }

    /**
     * Changes the actual scene of the stage. (The content of the window)
     *
     * @param controller The controller to use as the active controller
     */
    public void changeScene(BaseController controller) {
        URL url = getClass().getResource("/resources/views/" + controller.getViewName() + ".fxml");
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
