package com.ciberman.atm.models;

import com.ciberman.atm.services.Authenticatable;

import java.io.Serializable;
import java.math.BigInteger;

public class Card extends Authenticatable implements Serializable {

    private BigInteger number;

    private User owner;


    public Card(User owner, BigInteger number, String password) {
        this.number = number;
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


}
