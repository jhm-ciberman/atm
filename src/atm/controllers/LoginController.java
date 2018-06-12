package atm.controllers;

import atm.App;
import atm.models.User;
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

    public LoginController(App app) {
        super(app);
    }

    @Override
    public String getViewName() {
        return "login";
    }

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) {
        User user = atm.users.get(0);
        AuthService auth = new AuthService();
        if (auth.check(user, pinField.getText())) {
            app.changeScene(new MainMenuController(app));
        } else {
            // TODO: replace with a better error output
            System.out.println("Invalid login");
        }
    }
}
