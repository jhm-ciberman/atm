package com.ciberman.atm.controllers;

import com.ciberman.atm.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.jetbrains.annotations.Nullable;

import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("WeakerAccess")
public class SuccessController extends BaseController implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private Label subtitleLabel;

    @FXML
    private Button button;

    @Nullable
    private String title;
    @Nullable
    private String subtitle;
    @Nullable
    private String buttonText;

    @FXML
    public void onCancelPressed(ActionEvent e) {
        router.showMainMenu();
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
        if (this.title != null) {
            this.titleLabel.setText(this.title);
        }
        if (this.subtitle != null) {
            this.subtitleLabel.setText(this.subtitle);
        }
        if (this.buttonText != null) {
            this.button.setText(this.buttonText);
        }
    }

    public SuccessController setTitle(String text) {
        this.title = text;
        return this;
    }

    public SuccessController setSubtitle(String text) {
        this.subtitle = text;
        return this;
    }

    public SuccessController setButtonText(String text) {
        this.buttonText = text;
        return this;
    }

    @Override
    public String getViewName() {
        return Views.SUCCESS;
    }


}
