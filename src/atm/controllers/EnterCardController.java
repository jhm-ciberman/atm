package atm.controllers;

import atm.App;
import atm.models.Card;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.math.BigInteger;

public class EnterCardController extends BaseController {

    @FXML
    private TextField cardNumberField;

    public EnterCardController(App app) {
        super(app);
    }

    /**
     * @return Returns the name of the fxml file (without
     * extension) of the view related to this controller.
     */
    @Override
    public String getViewName() {
        return "enter_card";
    }


    @FXML
    public void onEnterCardPressed(ActionEvent event) {
        System.out.println("Card entered " + cardNumberField.getText());

        BigInteger number = new BigInteger(cardNumberField.getText());
        Card card = atm.cards.stream()
                .filter(e -> e.getNumber().equals(number))
                .findFirst()
                .orElse(null);

        if (card != null) {
            app.changeScene(new LoginController(app, card));
        } else {
            /// TODO: what to do if the card is not found?
            System.out.println("Card " + number.toString() + " not found");
        }

    }
}
