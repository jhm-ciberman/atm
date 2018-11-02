package com.ciberman.atm.models.wallet;

import com.ciberman.atm.exceptions.InvalidOperationException;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Wallet implements Comparable<Wallet> {

    private BigDecimal billType;

    private int amount;

    private int pendingExtractionAmount = 0;

    public Wallet(BigDecimal billType, int amount) {
        this.billType = billType;
        this.amount = amount;
    }

    public BigDecimal getBillType() {
        return billType;
    }

    public int getAmountOfBills() {
        return amount;
    }

    public BigDecimal getValue() {
        return billType.multiply(new BigDecimal(amount));
    }

    public void decrement(int amount) throws InvalidOperationException {
        if (this.amount >= amount) {
            this.pendingExtractionAmount = amount;
        } else {
            throw new InvalidOperationException("No enough amount of bills");
        }
    }

    public BigDecimal decrementUpTo(BigDecimal value) throws InvalidOperationException {
        int n = value.divideToIntegralValue(billType).intValue();
        n = Math.min(n, this.getAmountOfBills());
        BigDecimal extracted = billType.multiply(new BigDecimal(n));
        this.decrement(n);
        System.out.println("Extracted $" + extracted + " in " + n + " bills of $" + billType);
        return extracted;
    }

    public void commit() {
        this.amount -= this.pendingExtractionAmount;
        this.pendingExtractionAmount = 0;
    }

    public void rollback() {
        this.pendingExtractionAmount = 0;
    }

    public int getPendingExtractionAmount() {
        return pendingExtractionAmount;
    }

    public void increment(int amount) {
        this.amount += amount;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(@NotNull Wallet o) {
        // Note: This is the negated comparison, so, the elements will be in descending order
        return -this.getBillType().compareTo(o.getBillType());
    }


}
