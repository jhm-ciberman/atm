package com.ciberman.atm;

import com.ciberman.atm.exceptions.UnauthorizedException;
import com.ciberman.atm.services.Authenticatable;
import com.google.inject.Singleton;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents the current Application context
 * That is, the shared data across the application.
 */
@Singleton
public class AppContext {

    @Nullable
    private Authenticatable authenticated;

    @Nullable
    private Authenticatable authenticatable;

    /**
     * Gets the current authenticated user
     */
    public @Nullable Authenticatable getAuthenticated() {
        return authenticated;
    }

    /**
     * Gets the current authenticated user. If the user is not authenticated, throw an Unauthorized Exception
     */
    public @NotNull Authenticatable getAuthenticatedOrFail() throws UnauthorizedException {
        if (authenticated == null) {
            throw new UnauthorizedException();
        }
        return authenticated;
    }



    /**
     * Sets the current authenticated user
     */
    public void setAuthenticated(@Nullable Authenticatable authenticated) {
        this.authenticated = authenticated;
    }

    /**
     * Gets the user that wants to be authenticated in the current app context
     */
    public @Nullable Authenticatable getAuthenticatable() {
        return authenticatable;
    }

    /**
     * Sets the user that wants to be authenticated in the current app context
     */
    public void setAuthenticatable(@Nullable Authenticatable currentCard) {
        this.authenticatable = currentCard;
    }


}