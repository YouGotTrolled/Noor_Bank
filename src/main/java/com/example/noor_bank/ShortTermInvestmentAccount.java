package com.example.noor_bank;

import java.io.File;
import java.util.List;

public class ShortTermInvestmentAccount extends BankAccount {
    private static final long serialVersionUID = 1;
    private Loan loan;

    //constructor
    public ShortTermInvestmentAccount(Account owner) {
        super(owner, 2.5f);
        this.setBill(new File(".\\systemFiles\\bills\\" + getOwner().getUsername() + "\\S.txt"));
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
        return "ShortTermInvestmentAccount acc " + this.getOwner().getNameAndLastName();
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