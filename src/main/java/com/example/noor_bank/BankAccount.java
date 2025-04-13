package com.example.noor_bank;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1;
    public static long numberOfAccounts = 0;
    private Account owner;
    private long accountNumberId;
    private String shaba;
    private Card cards;
    private long balance;
    private float interest;
    private List<Notification> notifications;
    private File bill;

    static {

    }

    //constructor
    public BankAccount(Account owner, float interest) {
        this.owner = owner;
        this.accountNumberId = 100000000000L + numberOfAccounts++;
        this.shaba = "IR000000000000" + accountNumberId;
        this.cards = new Card(this);
        this.interest = interest;
        this.notifications = new ArrayList<>();
        this.balance = 10_000;
        notifications.add(new Notification("به بانک نور خوش امدید"));
    }

    public BankAccount() {
        this(new Account(),0);
    }

    // Getter and Setter for owner
    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    // Getter and Setter for accountNumberId
    public long getAccountNumberId() {
        return accountNumberId;
    }

    public void setAccountNumberId(long accountNumberId) {
        this.accountNumberId = accountNumberId;
    }

    // Getter and Setter for shaba
    public String getShaba() {
        return shaba;
    }

    public void setShaba(String shaba) {
        this.shaba = shaba;
    }

    // Getter and Setter for cards
    public Card getCards() {
        return cards;
    }

    public void setCards(Card cards) {
        this.cards = cards;
    }

    // Getter and Setter for shaba
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    // Getter and Setter for interest
    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    // Getter and Setter for notifications
    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    // Getter and Setter for bill
    public File getBill() {
        return bill;
    }

    public void setBill(File bill) {
        this.bill = bill;
    }

    //methods
    public String toString() {
        return "BA of "+owner.getNameAndLastName();
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof BankAccount)
            result = accountNumberId==((BankAccount) o).getAccountNumberId();
        return result;
    }

    public int hashCode() {
        return shaba.hashCode();
    }

    public synchronized void spendBalance(long amount) throws NotEnoughMoney {
        if (amount > balance) {
            throw new NotEnoughMoney();
        } else {
            balance = balance - amount;
            try(PrintWriter writer=new PrintWriter(new FileOutputStream(bill.getAbsolutePath(),true))){
                writer.write("برداشت از حساب به مقدار "+amount+" در تاریخ "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void notificationRead(int index){
        notifications.get(index).setRead(true);
    }

    public synchronized void addToBalance(long amount){
        balance=balance+amount;
        try(PrintWriter writer=new PrintWriter(new FileOutputStream(bill.getAbsolutePath(),true))){
            writer.write("واریز به حساب به مقدار "+amount+" در تاریخ "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void checkInterest(){
        balance= (long) (balance+balance*interest);
    }

}