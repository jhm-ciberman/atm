package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.InvalidOperationException;
import com.ciberman.atm.models.ATMProvider;
import com.ciberman.atm.models.wallet.Wallet;
import com.google.inject.Inject;

import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;

public class ExtractionService {

    @Inject
    private ATMProvider atmProvider;

    private SortedSet<Wallet> getSortedWalletList() {
        return new TreeSet<>(atmProvider.getAtm().walletsList);
    }

    public void performDryRun(BigDecimal number) throws InvalidOperationException {
        for (Wallet wallet : this.getSortedWalletList()) {
            BigDecimal valueExtracted = wallet.decrementUpTo(number);
            number = number.subtract(valueExtracted);
        }

        if (!number.equals(BigDecimal.ZERO)) {
            throw new InvalidOperationException("El cajero no dispone del dinero solicitado. Elija otro monto");
        }
    }

    public void commit() {
        this.getSortedWalletList().forEach(Wallet::commit);
    }

    public void rollback() {
        this.getSortedWalletList().forEach(Wallet::rollback);
    }

}
