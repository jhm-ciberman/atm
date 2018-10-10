package com.ciberman.atm.controllers;

import com.ciberman.atm.exceptions.ATMError;

/**
 * This is interface can be implemented by any
 * controller that requires to use a middleware
 *
 * The interface contains a single method that is called by
 * the controller before displaying the View associated to that
 * controller on the screen.
 *
 * This method can perform validations before showing the View to the user
 * and throw any ATMError Exception if something is invalid.
 *
 * For example, it can be used to check if the user is authenticated, and if not,
 * throw a UnauthenticatedException.
 *
 */
public interface HasMidleware {

    void handleMiddleware() throws ATMError;
}
