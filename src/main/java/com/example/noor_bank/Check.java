package com.example.noor_bank;

public class Check {
    private BankAccount from;
    private BankAccount to;
    private long amount;
    private int date;

    //constructor
    public Check(BankAccount from, BankAccount to, long amount, int date) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
    }

    // Getter and Setter for from
    public BankAccount getFrom() {
        return from;
    }

    public void setFrom(BankAccount from) {
        this.from = from;
    }

    // Getter and Setter for to
    public BankAccount getTo() {
        return to;
    }

    public void setTo(BankAccount to) {
        this.to = to;
    }

    // Getter and Setter for amount
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    // Getter and Setter for date
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    //methods
    public String toString() {
        return "check from " + from.getUsername() + " to " + to.getUsername();
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Check)
            result = from.equals(((Check) o).from) && to.equals(((Check) o).to) && amount == ((Check) o).amount && date == ((Check) o).date;
        return result;
    }

    public int hashCode() {
        return from.hashCode();
    }
}