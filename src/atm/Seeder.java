package atm;

import atm.models.ATM;
import atm.models.User;

class Seeder {

    /**
     * Seeds the passed ATM Database Model with random data
     *
     * @param atm The ATM Database model to seed
     */
    void seed(ATM atm) {
        atm.users.add(new User("1234"));
    }
}
