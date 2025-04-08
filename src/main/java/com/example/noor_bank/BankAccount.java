package com.example.noor_bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Serializable {
    private static long numberOfAccounts;
    private String username;
    private String password;
    private List<Account> owner;
    private long accountNumberId;
    //12
    private String shaba;
    //26
    private List<Card> cards;
    private long balance;
    private float interest;

    static {
        //load numberOfAccounts
    }

    //constructor
    public BankAccount(String username, String password, List<Account> owner, float interest) {
        this.username = username;
        this.password = password;
        this.owner = owner;
        this.accountNumberId = 100000000000L + numberOfAccounts++;
        this.shaba = "IR000000000000" + accountNumberId;
        this.cards = new ArrayList<>();
        this.interest = interest;
    }

    public BankAccount(String username, String password, Account owner) {
        this(username, password, List.of(owner), 0);
    }

    public BankAccount() {
        this("defaultUserName", "1234", new Account());
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for owner
    public List<Account> getOwner() {
        return owner;
    }

    public void setOwner(List<Account> owner) {
        this.owner = owner;
    }

    // Getter and Setter for accountNumberId
    public long getAccountNumberId() {
        return accountNumberId;
    }

    public void setAccountNumberId(long accountNumberId) {
        this.accountNumberId = accountNumberId;
    }

    // Getter and Setter for shaba
    public String getShaba() {
        return shaba;
    }

    public void setShaba(String shaba) {
        this.shaba = shaba;
    }

    // Getter and Setter for cards
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    // Getter and Setter for shaba
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    // Getter and Setter for interest
    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    //methods
    public String toString() {
        return username;
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof BankAccount)
            result = username.equals(((BankAccount) o).getUsername());
        return result;
    }

    public int hashCode() {
        return username.hashCode();
    }

    public synchronized void spendBalance(long amount) throws NotEnoughMoney {
        if (amount > balance) {
            throw new NotEnoughMoney();
        } else {
            balance = balance - amount;
        }
    }
}