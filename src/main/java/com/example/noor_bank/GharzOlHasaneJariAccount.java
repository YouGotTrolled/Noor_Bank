package com.example.noor_bank;

import java.util.ArrayList;
import java.util.List;

public class GharzOlHasaneJariAccount extends BankAccount {
    private Loan loan;
    private List<Check> checkList;
    private static final long serialVersionUID = 1;

    //constructor
    public GharzOlHasaneJariAccount(String username, String password, List<Account> owner) {
        super("G_"+username, password, owner, 0);
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

    public synchronized void checkLoan(int todayDate){
        if(loan!=null) {
            if (todayDate >= loan.getDateOfLastPayment() && loan.getNumberOfMonth() > 0) {
                //
                int temp = todayDate - loan.getDateOfStarting();
                temp /= 100;
                temp = temp / 100 * 12 + temp;
                //
                int numberOfMonthLeft = temp-loan.getNumberOfMonth();
                //
                if (temp>loan.getNumberOfMonth()) {
                    temp = loan.getNumberOfMonth();
                    numberOfMonthLeft=0;
                }
                //
                long payment = loan.getPayment(temp);
                try {
                    spendBalance(payment);
                    loan.setNumberOfMonth(numberOfMonthLeft);
                    if(numberOfMonthLeft==0)
                        loan=null;
                } catch (NotEnoughMoney e) {
                    System.out.println("no money");
                }
            }
        }
    }
}