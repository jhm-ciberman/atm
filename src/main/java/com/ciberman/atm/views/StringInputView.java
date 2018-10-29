package com.ciberman.atm.views;

import com.ciberman.atm.Views;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class StringInputView extends BaseView implements Initializable {

    @FXML
    protected Label titleLabel;

    @FXML
    protected Label subtitleLabel;

    @FXML
    protected TextField amountTextField;

    @FXML
    protected Label infoLabel;

    @FXML
    protected Button continueButton;

    private final Consumer<String> onAmountEntered;

    private final Runnable onCancel;

    private final StringInputViewData data;

    public StringInputView(StringInputViewData data, Consumer<String> onAmountEntered, Runnable onCancel) {
        this.data = data;
        this.onAmountEntered = onAmountEntered;
        this.onCancel = onCancel;
    }

    @FXML
    void onContinuePressed() {
        this.onAmountEntered.accept(amountTextField.getText());
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
        this.titleLabel.setText(this.data.getTitle());
        this.subtitleLabel.setText(this.data.getSubtitle());
        this.infoLabel.setText(this.data.getInfo());
        this.amountTextField.setPromptText(this.data.getInfo());
        this.continueButton.setText(this.data.getButtonText());
    }

    @Override
    public String getViewName() {
        return Views.STRING_INPUT;
    }

    @FXML
    public void onCancelPressed() {
        this.onCancel.run();
    }
}
