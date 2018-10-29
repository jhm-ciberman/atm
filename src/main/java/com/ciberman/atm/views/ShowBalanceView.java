package com.ciberman.atm.views;

import com.ciberman.atm.Views;
import com.ciberman.atm.models.account.Account;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowBalanceView extends BaseView implements Initializable {

    @FXML
    private Label balanceLabel;

    @FXML
    private Label accountNameLabel;

    private Account account;

    private Runnable onContinuePressed;

    public ShowBalanceView(Account account, Runnable onContinuePressed) {
        this.account = account;
        this.onContinuePressed = onContinuePressed;
    }

    @FXML
    private void onCancelPressed() {
        this.onContinuePressed.run();
    }

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
        BigDecimal balance = account.getBalance();
        String str = "$ " + balance.toString();
        balanceLabel.setText(str);
        accountNameLabel.setText(account.getName());
    }

    public ShowBalanceView setAccount(Account account) {
        this.account = account;
        return this;
    }

    @Override
    public String getViewName() {
        return Views.SHOW_BALANCE;
    }


}
