package atm.models;

import atm.services.Authenticatable;
import util.Passwords;

import java.io.Serializable;

/**
 * Represents a User
 */
public class User implements Authenticatable, Serializable {
    private byte[] password;
    private byte[] salt;

    public User(String password) {
        this.updatePassword(password);
    }

    public void updatePassword(String password) {
        this.salt = Passwords.getNextSalt();
        this.password = Passwords.hash(password.toCharArray(), this.salt);
    }

    @Override
    public byte[] getPassword() {
        return password;
    }

    @Override
    public byte[] getSalt() {
        return salt;
    }
}
