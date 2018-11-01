package com.ciberman.atm.views;

import com.ciberman.atm.models.account.Account;
import com.ciberman.atm.models.movements.Movement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowMovementsView extends BaseView implements Initializable {

    private final Account account;

    private final Runnable onFinish;

    @FXML
    private TableView<Movement> movementsTable;

    @FXML
    private Label accountNameLabel;

    public ShowMovementsView(Account account, Runnable onFinish) {
        this.account = account;
        this.onFinish = onFinish;
    }

    @FXML
    private void onCancelPressed() {
        this.onFinish.run();
    }


    @Override
    public String getViewName() {
        return Views.SHOW_MOVEMENTS;
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
        this.accountNameLabel.setText(account.getName());

        this.addColumn("Fecha", "date");
        this.addColumn("Descripción", "description");
        this.addColumn("Monto", "amount");

        for (Movement movement : this.account.getMovements()) {
            this.movementsTable.getItems().add(movement);
        }

    }

    @SuppressWarnings("SameParameterValue")
    private void addColumn(String label, String property) {
        TableColumn<Movement, Movement> column = new TableColumn<>(label);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        this.movementsTable.getColumns().add(column);
    }
}
