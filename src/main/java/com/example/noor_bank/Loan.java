package com.example.noor_bank;

import java.io.Serializable;

public class Loan implements Serializable {
    private static final long serialVersionUID = 1;
    private long amount;
    private float interest;
    private int dateOfLastPayment;
    private int dateOfStarting;
    private int numberOfMonth;

    //constructor
    public Loan(long amount, float interest, int dateOfStarting, int numberOfMonth) {
        this.amount = amount;
        this.interest = interest;
        this.dateOfLastPayment = dateOfStarting;
        this.dateOfStarting = dateOfStarting;
        this.numberOfMonth = numberOfMonth;
    }

    // Getter and Setter for amount
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    // Getter and Setter for interest
    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    // Getter and Setter for dateOfLastPayment
    public int getDateOfLastPayment() {
        return dateOfLastPayment;
    }

    public void setDateOfLastPayment(int dateOfLastPayment) {
        this.dateOfLastPayment = dateOfLastPayment;
    }

    // Getter and Setter for dateOfStarting
    public int getDateOfStarting() {
        return dateOfStarting;
    }

    public void setDateOfStarting(int dateOfStarting) {
        this.dateOfStarting = dateOfStarting;
    }

    // Getter and Setter for numberOfMonth
    public int getNumberOfMonth() {
        return numberOfMonth;
    }

    public void setNumberOfMonth(int numberOfMonth) {
        this.numberOfMonth = numberOfMonth;
    }

    //methods
    public String toString() {
        return "loan of " + amount;
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Loan)
            result = amount == ((Loan) o).amount && interest == ((Loan) o).interest;
        return result;
    }

    public int hashCode() {
        return Math.toIntExact(amount);
    }

    public long getPayment(int month){
        long payment=month*(long)interest*amount/100;
        return payment;
    }
}