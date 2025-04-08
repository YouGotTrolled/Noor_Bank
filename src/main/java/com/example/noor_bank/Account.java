package com.example.noor_bank;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    private String name;
    private String lastName;
    private String username;
    private String password;
    private int dateOfBirth;
    private long id;
    private long phoneNumber;
    private File personalLog;
    private File personalPicture;
    private List<BankAccount> accountsList;
    private boolean verification;

    //constructor
    public Account(String name, String lastName, String username, String password, int dateOfBirth, long id, long phoneNumber, File personalLog, File personalPicture, boolean verification) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.personalLog = personalLog;
        this.personalPicture = personalPicture;
        this.accountsList = new ArrayList<>();
        this.verification = verification;
    }

    public Account(String name, String lastName, String username, String password, int dateOfBirth, long id, long phoneNumber) {
        this(name, lastName, username, password, dateOfBirth, id, phoneNumber, new File(".\\systemFiles\\userLog\\" + username + ".txt"), new File(".\\systemFiles\\userPicture\\" + username + ".png"), false);
    }

    public Account() {
        this("defaultName", "defaultLastName", "defaultUserName", "1234", 1350_1_1, 1, 1);
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    // Getter and Setter for dateOfBirth
    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Getter and Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for phoneNumber
    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter for personalLog
    public File getPersonalLog() {
        return personalLog;
    }

    public void setPersonalLog(File personalLog) {
        this.personalLog = personalLog;
    }

    // Getter and Setter for personalPicture
    public File getPersonalPicture() {
        return personalPicture;
    }

    public void setPersonalPicture(File personalPicture) {
        this.personalPicture = personalPicture;
    }

    // Getter and Setter for accountsList
    public List<BankAccount> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<BankAccount> accountsList) {
        this.accountsList = accountsList;
    }

    // Getter and Setter for verification
    public boolean getVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    //methods
    public String toString() {
        return (username + " (" + accountsList + ")");
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Account)
            result = username.equals(((Account) o).getUsername());
        return result;
    }

    public int hashCode() {
        return username.hashCode();
    }
}