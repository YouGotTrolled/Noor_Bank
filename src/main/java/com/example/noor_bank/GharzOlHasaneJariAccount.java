package com.example.noor_bank;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GharzOlHasaneJariAccount extends BankAccount {
    private Loan loan;
    private List<Check> checkList;
    private static final long serialVersionUID = 1;

    //constructor
    public GharzOlHasaneJariAccount(Account owner) {
        super(owner, 0);
        this.checkList = new ArrayList<>();
        this.setBill(new File(".\\systemFiles\\bills\\" + getOwner().getUsername() + "\\G.txt"));
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
        return "GharzOlHasaneJariAccount acc " + this.getOwner().getNameAndLastName();
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
                    getNotifications().add(new Notification("پول نداری"));
                }
            }
        }
    }

    public synchronized void checkCheck(int todayDate){
        if(!checkList.isEmpty()) {
            for (Check check : checkList) {
                if (todayDate>=check.getDate()){
                    try{
                        check.getFrom().spendBalance(check.getAmount());
                        check.getTo().addToBalance(check.getAmount());
                        checkList.remove(check);
                    } catch (NotEnoughMoney e) {
                        System.out.println("no money");
                        check.getFrom().getNotifications().add(new Notification("پول برای چک نداری"));
                        check.getTo().getNotifications().add(new Notification("چک شما برگشت خورد"));
                    }
                }
            }
        }
    }
}