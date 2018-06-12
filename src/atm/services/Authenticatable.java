package atm.services;

import util.Passwords;

import java.io.Serializable;

/**
 * Represents an authenticatable entity
 */
public abstract class Authenticatable implements Serializable {
    private byte[] password;
    private byte[] salt;

    /**
     * Updates the password
     *
     * @param password The new password
     */
    public void updatePassword(String password) {
        this.salt = Passwords.getNextSalt();
        this.password = Passwords.hash(password.toCharArray(), this.salt);
    }

    /**
     * @return The hashed password
     */
    public byte[] getPassword() {
        return password;
    }

    /**
     * @return The used salt used to hash the password
     */
    public byte[] getSalt() {
        return salt;
    }
}
