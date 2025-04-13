package com.example.noor_bank;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LongTermInvestmentAccount extends BankAccount {
    private static final long serialVersionUID = 1;

    //constructor
    public LongTermInvestmentAccount(Account owner) {
        super(owner, 12.5f);
        this.setBill(new File(".\\systemFiles\\bills\\" + getOwner().getUsername() + "\\L.txt"));
    }

    //methods
    public String toString() {
        return "LongTermInvestmentAccount acc " + this.getOwner().getNameAndLastName();
    }

    public synchronized void spendBalance(long amount) throws NotEnoughMoney {
        if (amount > getBalance() * 0.5) {
            throw new NotEnoughMoney();
        } else {
            setBalance(((long) (getBalance() * 0.5)) - amount);
            try(PrintWriter writer=new PrintWriter(new FileOutputStream(getBill().getAbsolutePath(),true))){
                writer.write("برداشت از حساب به مقدار "+amount+" در تاریخ "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}