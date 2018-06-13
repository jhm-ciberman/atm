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

    private static final int MAX_LOGIN_ATTEMPTS = 3;

    private Card card;
    @FXML
    private PasswordField pinField;

    public LoginController(App app, Card card) {
        super(app);
        this.card = card;
    }


    @Override
    public String getViewName() {
        return "login";
    }

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) throws Exception {
        new AuthService().check(card, pinField.getText());

        System.out.println("Login successful");
        app.getRouter().gotoMainMenu();

    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        app.getRouter().gotoEnterCard();
    }
}
