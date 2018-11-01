package com.ciberman.atm.operations;

import com.ciberman.atm.views.StringInputView;
import com.ciberman.atm.views.StringInputViewData;

import java.util.function.Consumer;

public class EnterStringOperation extends Operation {

    public void start(StringInputViewData data, Consumer<String> onStringEntered, Runnable onCancel) {
        router.showController(new StringInputView(data, onStringEntered, onCancel));
    }
}
