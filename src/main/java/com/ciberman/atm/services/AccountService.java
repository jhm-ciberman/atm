package com.ciberman.atm.services;

import com.ciberman.atm.exceptions.InsufficientFundsException;
import com.ciberman.atm.exceptions.InvalidOperationException;
import com.ciberman.atm.models.account.Account;
import com.ciberman.atm.models.movements.Movement;
import com.ciberman.atm.models.movements.Transference;
import com.google.inject.Inject;

import java.math.BigDecimal;
import java.util.Date;

public class AccountService {

    @Inject
    private DateProvider dateProvider;

    @Inject
    private ExtractionService extractionService;

    public void withdraw(Account account, String amountString) throws InvalidOperationException, InsufficientFundsException {
        BigDecimal amount = new BigDecimal(amountString);
        if (this.checkIsInvalid(amount)) {
            throw new InvalidOperationException("El monto debe ser múltiplo de 100");
        }

        Date date = dateProvider.getCurrentDate();

        try {
            extractionService.performDryRun(amount);

            account.withdraw(amount);

            account.addMovement(new Movement(date, account, amount.negate()));

            extractionService.commit();
        } catch (InvalidOperationException | InsufficientFundsException e) {
            extractionService.rollback();
            throw e;
        }
    }

    public void deposit(Account account, String amountString) throws InvalidOperationException {
        BigDecimal amount = new BigDecimal(amountString);
        if (this.checkIsInvalid(amount)) {
            throw new InvalidOperationException("El monto debe ser múltiplo de 100");
        }

        Date date = dateProvider.getCurrentDate();

        account.deposit(amount);

        account.addMovement(new Movement(date, account, amount));
    }

    public void transfer(Account sourceAccount, Account destinationAccount, String amountString) throws InvalidOperationException, InsufficientFundsException {
        BigDecimal amount = new BigDecimal(amountString);

        if (this.checkIsInvalid(amount)) {
            throw new InvalidOperationException("El monto debe ser múltiplo de 100");
        }

        Date date = dateProvider.getCurrentDate();

        sourceAccount.withdraw(amount);
        destinationAccount.deposit(amount);

        Movement outcomingMovement = new Transference(date, sourceAccount, destinationAccount, amount.negate());
        Movement incomingMovement = new Transference(date, destinationAccount, sourceAccount, amount);
        sourceAccount.addMovement(outcomingMovement);
        destinationAccount.addMovement(incomingMovement);
    }

    private boolean checkIsInvalid(BigDecimal amount) {
        return (!amount.remainder(new BigDecimal("100")).equals(BigDecimal.ZERO));
    }

}
