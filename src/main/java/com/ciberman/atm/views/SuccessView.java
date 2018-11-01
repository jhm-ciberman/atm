package com.ciberman.atm.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("WeakerAccess")
public class SuccessView extends BaseView implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private Label subtitleLabel;

    @FXML
    private Button button;


    private final String title;

    private final String subtitle;

    private final String buttonText;

    private final Runnable onCancelPressed;


    public SuccessView(String title, String subtitle, String buttonText, Runnable onCancelPressed) {
        this.title = title;
        this.subtitle = subtitle;
        this.buttonText = buttonText;
        this.onCancelPressed = onCancelPressed;
    }

    @FXML
    public void onCancelPressed(ActionEvent e) {
        this.onCancelPressed.run();
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

    @Override
    public String getViewName() {
        return Views.SUCCESS;
    }


}
