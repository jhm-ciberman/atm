package com.ciberman.atm.services;

import com.ciberman.atm.util.Passwords;


public class AuthService {

    /**
     * Match a given password with an Authenticatable instance.
     * @param authenticatable The user to authenticate
     * @param password        The password to validate
     */
    public boolean check(Authenticatable authenticatable, String password) {
        return (Passwords.isExpectedPassword(
                password.toCharArray(),
                authenticatable.getSalt(),
                authenticatable.getPassword()));
    }

    /**
     * Checks if the authenticatable has passed the number of attempts
     *
     * @param authenticatable The Authenticatable
     * @return True if has passed the number of attempts
     */
    public boolean hasTooManyAttempts(Authenticatable authenticatable) {
        return (authenticatable.getFailedLoginAttempts() >= authenticatable.getMaxLoginAttempts());
    }
}
