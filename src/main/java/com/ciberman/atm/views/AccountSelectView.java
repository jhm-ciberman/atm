package com.ciberman.atm.views;

import com.ciberman.atm.Views;
import com.ciberman.atm.models.Card;
import com.ciberman.atm.models.account.Account;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class AccountSelectView extends BaseView implements Initializable {

    @FXML
    private VBox accountButtonsContainer;

    private final Consumer<Account> onAccountSelected;

    private final Runnable onCancel;

    private final Card card;

    public AccountSelectView(Card card, Consumer<Account> onAccountSelected, Runnable onCancel) {
        this.card = card;
        this.onAccountSelected = onAccountSelected;
        this.onCancel = onCancel;
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
        Iterator<Account> accountIterator = this.card.getAccounts().iterator();

        // Foreach account, create a new button
        accountIterator.forEachRemaining((account) -> {
            Button b = this.createAccountButton(account);
            b.setOnAction((e) -> this.onAccountSelected.accept(account));
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
        this.onCancel.run();
    }

    @Override
    public String getViewName() {
        return Views.ACCOUNT_SELECT;
    }

}
