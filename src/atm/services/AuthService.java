package atm.services;

import util.Passwords;

public class AuthService {
    public AuthService() {

    }

    /**
     * Match a given password with an Authenticatable instance.
     *
     * @param authenticatable The Authenticatable instance to authenticate against
     * @param password        The password to validate
     * @return True if the password matches the authenticatable.
     */
    public boolean check(Authenticatable authenticatable, String password) {
        return Passwords.isExpectedPassword(
                password.toCharArray(),
                authenticatable.getSalt(),
                authenticatable.getPassword()
        );
    }


}
