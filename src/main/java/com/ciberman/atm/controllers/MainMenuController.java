
package com.ciberman.atm.controllers;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.login.RetrieveCardController;
import com.ciberman.atm.controllers.password.ChangePasswordController;
import com.ciberman.atm.controllers.transactions.AccountSelectController;
import com.ciberman.atm.controllers.transactions.DepositController;
import com.ciberman.atm.controllers.transactions.WithdrawController;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.User;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController extends BaseController {

    @Inject
    private AppContext appContext;

    @FXML
    private Label welcomeLabel;


    @FXML
    void initialize() throws UnauthorizedException {
        Card card = (Card) appContext.getAuthenticatedOrFail();
        User user = card.getOwner();
        this.welcomeLabel.setText("Bienvenido " + user.getName());
    }

    @FXML
    public void onExitPressed(ActionEvent e) {

        router.showController(RetrieveCardController.class);
    }


    @FXML
    public void onPasswordChangePressed(ActionEvent e) {
        router.showController(ChangePasswordController.class);
    }

    @FXML
    public void onCheckBalancePressed(ActionEvent e) {
        router.makeController(AccountSelectController.class)
                .setCallback(this::showBalance)
                .andShowView();
    }

    private void showBalance(Account account) {
        router.makeController(ShowBalanceController.class)
                .setAccount(account)
                .andShowView();
    }

    @FXML
    public void onRetrieveMoneyPressed(ActionEvent e) {
        router.showController(WithdrawController.class);
    }

    @FXML
    public void onDepositMoneyPressed(ActionEvent e) {
        router.showController(DepositController.class);
    }

    @FXML
    public void onCheckTransactionsPressed(ActionEvent e) {
        router.showController(ChangePasswordController.class);
    }

    @Override
    public String getViewName() {
        return Views.MAIN_MENU;
    }
}
