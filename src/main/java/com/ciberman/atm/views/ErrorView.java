package com.ciberman.atm.views;

import com.ciberman.atm.Views;
import com.ciberman.atm.exceptions.ATMError;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.jetbrains.annotations.Nullable;

import java.net.URL;
import java.util.ResourceBundle;


public class ErrorView extends BaseView implements Initializable {

    @FXML
    private Label errorTitleLabel;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    private ATMError error;

    @Nullable
    private Runnable andThen;

    public ErrorView(ATMError error, @Nullable Runnable andThen) {
        this.error = error;
        this.andThen = andThen;
    }

    @FXML
    public void onOkPressed(ActionEvent event) {
        System.out.println(this.error.redirect());
        if (this.andThen != null) {
            this.andThen.run();
        }
    }

    @Override
    public String getViewName() {
        return Views.ERROR;
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
        if (this.error != null) {
            errorTitleLabel.setText(this.error.getTitle());
            errorMessageLabel.setText(this.error.getDescription());
            if (this.error.redirect() == null) {
                okButton.setVisible(false);
            }
        } else {
            okButton.setVisible(false);

        }
    }
}