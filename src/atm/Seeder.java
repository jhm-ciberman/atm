package atm;

import atm.models.ATM;
import atm.models.Card;
import atm.models.User;

import java.math.BigInteger;

class Seeder {

    /**
     * Seeds the passed ATM Database Model with random data
     *
     * @param atm The ATM Database model to seed
     */
    void seed(ATM atm) {

        User user = new User();
        Card card = new Card(user, new BigInteger("123456789"), "1234");
        atm.cards.add(card);
        atm.users.add(user);
    }
}
