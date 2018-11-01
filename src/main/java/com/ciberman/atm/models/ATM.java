package com.ciberman.atm.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the whole ATM database. It is the root model in the hierarchy.
 */
public class ATM implements Serializable {

    public final Set<Bank> banks = new HashSet<>();

    public ATM() {

    }


}
