package com.ciberman.atm.controllers;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Router;
import com.ciberman.atm.Views;
import com.ciberman.atm.exceptions.NoAccountsException;
import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.function.Consumer;

public class AccountSelectController {

    @FXML
    private VBox accountButtonsContainer;

    @Inject
    private AppContext appContext;

    @Inject
    private Router router;

    @Nullable
    private Consumer<Account> callback = null;

    public void setCallback(@Nullable Consumer<Account> callback) {
        this.callback = callback;
    }

    @FXML
    void initialize() throws UnauthorizedException, NoAccountsException {
        Card card = (Card) appContext.getAuthenticatedOrFail();
        Iterator<Account> accountIterator = card.getAccounts();

        if (!accountIterator.hasNext()) {
            throw new NoAccountsException();
        }

        // Foreach account, create a new button
        accountIterator.forEachRemaining((account) -> {
            Button b = this.createAccountButton(account);
            b.setOnAction((e) -> {
                if (this.callback != null) {
                    this.callback.accept(account);
                }
            });
            this.accountButtonsContainer.getChildren().add(b);
        });
    }

    private Button createAccountButton(Account account) {
        Button button = new Button();
        button.setText(account.getName().toUpperCase());
        button.setPadding(new Insets(20));
        button.setPrefWidth(300);
        VBox.setMargin(button, new Insets(10));
        button.setFont(new Font("Calibri", 25));
        return button;
    }

    @FXML
    public void onCancelPressed() {
        router.goTo(Views.MAIN_MENU);
    }
}
