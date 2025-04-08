package com.example.noor_bank;

import java.util.List;

public class ShortTermInvestmentAccount extends BankAccount {
    private Loan loan;

    //constructor
    public ShortTermInvestmentAccount(String username, String password, List<Account> owner) {
        super(username, password, owner, 2.5f);
    }

    public ShortTermInvestmentAccount(String username, String password, Account owner) {
        this(username, password, List.of(owner));
    }

    // Getter and Setter for loan
    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    //methods
    public String toString() {
        return "ShortTermInvestmentAccount acc " + this.getUsername();
    }
}