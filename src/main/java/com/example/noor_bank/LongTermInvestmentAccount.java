package com.example.noor_bank;

import java.util.List;

public class LongTermInvestmentAccount extends BankAccount {

    //constructor
    public LongTermInvestmentAccount(String username, String password, List<Account> owner) {
        super(username, password, owner, 12.5f);
    }

    public LongTermInvestmentAccount(String username, String password, Account owner) {
        this(username, password, List.of(owner));
    }

    //methods
    public String toString() {
        return "LongTermInvestmentAccount acc " + this.getUsername();
    }

    public synchronized void spendBalance(long amount) throws NotEnoughMoney {
        if (amount > getBalance() * 0.5) {
            throw new NotEnoughMoney();
        } else {
            setBalance(((long) (getBalance() * 0.5)) - amount);
        }
    }
}