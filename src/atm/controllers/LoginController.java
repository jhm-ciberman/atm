package atm.controllers;

import atm.App;
import atm.exceptions.AuthenticationException;
import atm.exceptions.MaxLoginAttemptsReachedException;
import atm.services.AuthService;
import atm.services.Authenticatable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

/**
 * The controller for the PIN login screen.
 */
public class LoginController extends BaseController {

    private Authenticatable authenticatable;
    @FXML
    private PasswordField pinField;

    public LoginController(App app, Authenticatable authenticatable) {
        super(app);
        this.authenticatable = authenticatable;
    }


    @Override
    public String getViewName() {
        return "login";
    }

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) throws AuthenticationException, MaxLoginAttemptsReachedException {
        new AuthService().check(authenticatable, pinField.getText());

        System.out.println("Login successful");
        app.getRouter().gotoMainMenu();

    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        app.getRouter().gotoRetrieveCard();
    }
}
