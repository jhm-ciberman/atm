
package com.ciberman.atm.views;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Views;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MainMenuView extends BaseView implements Initializable {

    @Inject
    private AppContext appContext;

    @FXML
    private Label welcomeLabel;

    private String title;

    private Consumer<MainMenuOption> onOptionSelected;

    public MainMenuView(String title, Consumer<MainMenuOption> onOptionSelected) {
        this.title = title;
        this.onOptionSelected = onOptionSelected;
    }

    @FXML
    public void onExitPressed(ActionEvent e) {
        this.onOptionSelected.accept(MainMenuOption.END);
    }


    @FXML
    public void onPasswordChangePressed(ActionEvent e) {
        this.onOptionSelected.accept(MainMenuOption.CHANGE_PIN);
    }

    @FXML
    public void onCheckBalancePressed(ActionEvent e) {
        this.onOptionSelected.accept(MainMenuOption.SHOW_BALANCE);
    }

    @FXML
    public void onRetrieveMoneyPressed(ActionEvent e) {
        this.onOptionSelected.accept(MainMenuOption.WITHDRAW);
    }

    @FXML
    public void onDepositMoneyPressed(ActionEvent e) {
        this.onOptionSelected.accept(MainMenuOption.DEPOSIT);
    }

    @FXML
    public void onCheckTransactionsPressed(ActionEvent e) {
        this.onOptionSelected.accept(MainMenuOption.SHOW_TRANSACTIONS);
    }

    @Override
    public String getViewName() {
        return Views.MAIN_MENU;
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
        this.welcomeLabel.setText(this.title);
    }
}
