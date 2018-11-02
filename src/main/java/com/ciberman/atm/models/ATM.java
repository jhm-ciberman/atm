package com.ciberman.atm.models;

import com.ciberman.atm.models.wallet.Wallet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents the whole ATM database. It is the root model in the hierarchy.
 */
public class ATM implements Serializable {

    public final Set<Bank> banks = new HashSet<>();

    public final List<Wallet> walletsList = new ArrayList<>();

    public ATM() {

    }


}
