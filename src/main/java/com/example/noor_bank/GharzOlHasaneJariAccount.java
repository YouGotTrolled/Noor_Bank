package com.example.noor_bank;

import java.util.ArrayList;
import java.util.List;

public class GharzOlHasaneJariAccount extends BankAccount {
    private Loan loan;
    private List<Check> checkList;

    //constructor
    public GharzOlHasaneJariAccount(String username, String password, List<Account> owner) {
        super(username, password, owner, 0);
        this.checkList = new ArrayList<>();
    }

    public GharzOlHasaneJariAccount(String username, String password, Account owner) {
        this(username, password, List.of(owner));
    }

    // Getter and Setter for loan
    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    // Getter and Setter for checkList
    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
    }

    //methods
    public String toString() {
        return "GharzOlHasaneJariAccount acc " + this.getUsername();
    }
}