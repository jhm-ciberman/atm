package com.ciberman.atm.models;

import com.ciberman.atm.exceptions.InvalidCardRangeException;
import com.ciberman.atm.models.account.SavingsAccount;
import com.ciberman.atm.models.wallet.Wallet;
import com.google.inject.Singleton;

import java.math.BigDecimal;
import java.math.BigInteger;

@Singleton
public class ATMProvider {

    /**
     * @return The ATM root Model
     */
    public ATM getAtm() {
        ATM atm = new ATM();

        atm.banks.add(this.createBank());

        atm.walletsList.add(this.createWallet(100, 200));
        atm.walletsList.add(this.createWallet(500, 200));
        atm.walletsList.add(this.createWallet(50, 120));

        return atm;
    }

    private Wallet createWallet(int billType, int amount) {
        return new Wallet(new BigDecimal(billType), amount);
    }

    private Bank createBank() {
        Bank bank = new Bank("Banco de la Plaza", new BigInteger("0"), new BigInteger("999999999"));

        try {
            User user = new User("Javier", "Mora");
            Card card = new Card(new BigInteger("123456789"), "1234", user);

            card.addAccount(new SavingsAccount("123", new BigDecimal("1234")));
            card.addAccount(new SavingsAccount("456", new BigDecimal("5678")));

            bank.addCard(card);
        } catch (InvalidCardRangeException e) {
            e.printStackTrace();
        }

        return bank;

    }

}
