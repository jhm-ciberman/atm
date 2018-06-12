package atm.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the whole ATM database. It is the root model in the hierarchy.
 */
public class ATM implements Serializable {

    public final List<User> users = new LinkedList<>();

    public ATM() {

    }


}
