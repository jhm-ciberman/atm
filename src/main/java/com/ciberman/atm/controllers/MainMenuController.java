
package com.ciberman.atm.controllers;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.login.RetrieveCardController;
import com.ciberman.atm.controllers.password.ChangePasswordController;
import com.ciberman.atm.controllers.transactions.AccountSelectController;
import com.ciberman.atm.controllers.transactions.DepositController;
import com.ciberman.atm.controllers.transactions.WithdrawController;
import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.User;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MainMenuController extends BaseController implements Initializable {

    @Inject
    private AppContext appContext;

    @FXML
    private Label welcomeLabel;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        this.selectAccountAndThen((account) -> {
            router.makeController(WithdrawController.class)
                    .setAccount(account)
                    .andShowView();
        });
    }

    private void selectAccountAndThen(Consumer<Account> callback) {
        router.makeController(AccountSelectController.class)
                .setCallback(callback)
                .andShowView();
    }

    @FXML
    public void onDepositMoneyPressed(ActionEvent e) {
        this.selectAccountAndThen(this::showDepositScreen);

    }

    private void showDepositScreen(Account account) {
        router.makeController(DepositController.class)
                .setAccount(account)
                .andShowView();
    }

    @FXML
    public void onCheckTransactionsPressed(ActionEvent e) {
        this.selectAccountAndThen((account -> {
            router.makeController(DepositController.class)
                    .setAccount(account)
                    .andShowView();
        }));
    }

    @Override
    public String getViewName() {
        return Views.MAIN_MENU;
    }


}
