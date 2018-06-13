package atm.controllers;

import atm.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController extends BaseController {

    public MainMenuController(App app) {
        super(app);
    }

    @Override
    public String getViewName() {
        return "main_menu";
    }

    @FXML
    public void onExitPressed(ActionEvent e) {
        app.getRouter().gotoRetrieveCard();
    }


    @FXML
    public void onPasswordChangePressed(ActionEvent e) {

    }

    @FXML
    public void onCheckBalancePressed(ActionEvent e) {

    }

    @FXML
    public void onRetrieveMoneyPressed(ActionEvent e) {

    }

    @FXML
    public void onDepositMoneyPressed(ActionEvent e) {

    }

    @FXML
    public void onTransferMoneyPressed(ActionEvent e) {

    }

    @FXML
    public void onCheckTransactionsPressed(ActionEvent e) {

    }

}
