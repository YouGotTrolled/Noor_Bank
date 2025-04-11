package com.example.noor_bank;

import java.util.List;

public class ShortTermInvestmentAccount extends BankAccount {
    private static final long serialVersionUID = 1;
    private Loan loan;

    //constructor
    public ShortTermInvestmentAccount(String username, String password, List<Account> owner) {
        super("S_"+username, password, owner, 2.5f);
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