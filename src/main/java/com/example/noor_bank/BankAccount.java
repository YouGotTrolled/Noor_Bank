package com.example.noor_bank;

import java.io.Serializable;
import java.util.List;

public class BankAccount implements Serializable {
    private String username;
    private String password;
    private List<Account> owner;

    //constructor
    public BankAccount(String username, String password, List<Account> owner) {
        this.username = username;
        this.password = password;
        this.owner = owner;
    }

    public BankAccount(String username, String password, Account owner) {
        this.username = username;
        this.password = password;
        this.owner = List.of(owner);
    }

    public BankAccount() {
        this("defaultUserName", "1234", List.of(new Account()));
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
}