package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.AuthenticationException;
import com.ciberman.atm.exceptions.MaxLoginAttemptsReachedException;
import com.ciberman.atm.util.Passwords;

public class AuthService {

    public AuthService() {

    }

    /**
     * Match a given password with an Authenticatable instance.
     * @param authenticatable The Authenticatable instance to authenticate against
     * @param password        The password to validate
     * @throws AuthenticationException If the password is incorrect
     * @throws MaxLoginAttemptsReachedException If the max login attempts is reached
     */
    public void check(Authenticatable authenticatable, String password) throws AuthenticationException, MaxLoginAttemptsReachedException {
        if (this.hasTooManyAttempts(authenticatable)) {
            throw new MaxLoginAttemptsReachedException();
        }

        if (!Passwords.isExpectedPassword(
                password.toCharArray(),
                authenticatable.getSalt(),
                authenticatable.getPassword())) {

            authenticatable.failLogin();

            if (this.hasTooManyAttempts(authenticatable)) {
                throw new MaxLoginAttemptsReachedException();
            }

            throw new AuthenticationException(authenticatable);
        }

        authenticatable.resetLoginAttempts();
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
