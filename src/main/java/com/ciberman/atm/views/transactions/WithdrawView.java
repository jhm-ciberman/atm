package com.ciberman.atm.views.transactions;

import com.ciberman.atm.Views;
import com.ciberman.atm.views.BaseView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class WithdrawView extends BaseView {
    @FXML
    protected TextField amountTextField;

    private Consumer<BigDecimal> onAmountEntered;

    private Runnable onCancel;

    public WithdrawView(Consumer<BigDecimal> onAmountEntered, Runnable onCancel) {
        this.onAmountEntered = onAmountEntered;
        this.onCancel = onCancel;
    }

    @FXML
    void onContinuePressed() {
        BigDecimal amount = new BigDecimal(amountTextField.getText());
        this.onAmountEntered.accept(amount);
    }

    @Override
    public String getViewName() {
        return Views.WITHDRAW_AMOUNT;
    }

    @FXML
    public void onCancelPressed() {
        this.onCancel.run();
    }
}
