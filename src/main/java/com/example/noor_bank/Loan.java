package com.example.noor_bank;

public class Loan {
    private long amount;
    private int interest;
    private int date;
    private int dateOfStarting;
    private int numberOfMonth;

    //constructor
    public Loan(long amount, int interest, int date, int dateOfStarting, int numberOfMonth) {
        this.amount = amount;
        this.interest = interest;
        this.date = date;
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
    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    // Getter and Setter for interest
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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
        return "loan of "+amount;
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Loan)
            result = amount==((Loan) o).amount&&interest==((Loan) o).interest;
        return result;
    }

    public int hashCode() {
        return Math.toIntExact(amount);
    }
}
