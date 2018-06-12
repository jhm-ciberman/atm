package atm.controllers;

import atm.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController extends BaseController {

    public LoginController(App app) {
        super(app);
    }

    @Override
    public String getViewName() {
        return "login";
    }

    @FXML
    public void onContinuePressed(ActionEvent actionEvent) {
        app.changeScene(new MainMenuController(app));
    }
}
