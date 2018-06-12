package atm.controllers;

import atm.App;
import atm.models.Card;
import atm.services.AuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

/**
 * The controller for the PIN login screen.
 */
public class LoginController extends BaseController {

    @FXML
    private PasswordField pinField;

    private Card card;

    public LoginController(App app, Card card) {
        super(app);
        this.card = card;
    }

    @Override
    public String getViewName() {
        return "login";
    }

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) {
        AuthService auth = new AuthService();
        if (auth.check(card, pinField.getText())) {
            System.out.println("Login successful");
            app.changeScene(new MainMenuController(app));
        } else {
            // TODO: replace with a better error output
            System.out.println("Invalid login");
        }
    }
}
