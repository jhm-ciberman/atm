package com.ciberman.atm.controllers.transactions;

import com.ciberman.atm.AppContext;
import com.ciberman.atm.Views;
import com.ciberman.atm.controllers.BaseController;
import com.ciberman.atm.exceptions.NoAccountsException;
import com.ciberman.atm.models.Account;
import com.ciberman.atm.models.Card;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.jetbrains.annotations.Nullable;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class AccountSelectController extends BaseController implements Initializable {

    @FXML
    private VBox accountButtonsContainer;

    @Inject
    private AppContext appContext;

    @Nullable
    private Consumer<Account> callback = null;

    public AccountSelectController setCallback(@Nullable Consumer<Account> callback) {
        this.callback = callback;
        return this;
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
        router.showMainMenu();
    }

    @Override
    public String getViewName() {
        return Views.ACCOUNT_SELECT;
    }

}
