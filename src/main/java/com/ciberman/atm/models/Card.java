package com.ciberman.atm.models;

import com.ciberman.atm.services.Authenticatable;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Card extends Authenticatable implements Serializable {

    private final BigInteger number;

    private User owner;

    private List<Account> accounts = new LinkedList<>();

    public Card(BigInteger number, String password, User owner) {
        this.number = number;
        this.owner = owner;
        this.updatePassword(password);
    }

    public BigInteger getNumber() {
        return number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

    public Iterator<Account> getAccounts() {
        return this.accounts.iterator();
    }
}
