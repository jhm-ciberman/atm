package com.ciberman.atm.controllers;

import com.ciberman.atm.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ErrorScreenController extends BaseController {

    private final String errorTitle;
    private final String errorMessage;
    private Runnable onOkClicked = null;

    @FXML
    private Label errorTitleLabel;
    @FXML
    private Label errorMessageLabel;
    @FXML
    private Button okButton;


    public ErrorScreenController(App app, String errorTitle, String errorMessage, Runnable onOkClicked) {
        super(app);
        this.errorTitle = errorTitle;
        this.errorMessage = errorMessage;
        this.onOkClicked = onOkClicked;
    }

    public ErrorScreenController(App app, String errorTitle, String errorMessage) {
        super(app);
        this.errorTitle = errorTitle;
        this.errorMessage = errorMessage;
    }

    @FXML
    public void initialize() {
        errorTitleLabel.setText(errorTitle);
        errorMessageLabel.setText(errorMessage);
        if (this.onOkClicked == null) {
            okButton.setVisible(false);
        }
    }


    /**
     * @return Returns the name of the fxml file (without
     * extension) of the view related to this controller.
     */
    @Override
    public String getViewName() {
        return "error";
    }

    @FXML
    public void onOkPressed(ActionEvent event) {
        if (this.onOkClicked != null) {
            onOkClicked.run();
        }
    }
}
