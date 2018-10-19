
package com.ciberman.atm.controllers;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.transactions.AccountSelectController;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.User;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController {

    @Inject
    private Router router;

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
        router.goTo(Views.RETRIEVE_CARD);
    }


    @FXML
    public void onPasswordChangePressed(ActionEvent e) {
        router.goTo(Views.CHANGE_PASSWORD);
    }

    @FXML
    public void onCheckBalancePressed(ActionEvent e) {
        AccountSelectController controller = router.goTo(Views.ACCOUNT_SELECT);
        if (controller != null) {
            controller.setCallback(this::showBalance);
        }
    }

    private void showBalance(Account account) {
        ShowBalanceController controller = router.goTo(Views.SHOW_BALANCE);
        if (controller != null) {
            controller.showBalanceFor(account);
        }
    }

    @FXML
    public void onRetrieveMoneyPressed(ActionEvent e) {
        router.goTo(Views.WITHDRAW_AMOUNT);
    }

    @FXML
    public void onDepositMoneyPressed(ActionEvent e) {
        router.goTo(Views.DEPOSIT_AMOUNT);
    }

    @FXML
    public void onCheckTransactionsPressed(ActionEvent e) {
        router.goTo(Views.CHANGE_PASSWORD);
    }

}
