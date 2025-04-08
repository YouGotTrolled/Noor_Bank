package com.example.noor_bank;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Card implements Serializable {
    private int numberOfCards;
    private BankAccount ownerAccount;
    private String ownerName;
    private int date;
    private int cvv;
    private long cardNumberId;
    private CardSkin cardSkin;

    static {
        //load numberOfCards
    }

    //constructor
    public Card(BankAccount ownerAccount, String ownerName, CardSkin cardSkin) {
        this.ownerAccount = ownerAccount;
        this.ownerName = ownerName;
        this.date = Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        this.cardNumberId = 6060_0606_0000_0000L + numberOfCards++;
        this.cvv = (new Random()).nextInt(4);
        this.cardSkin = cardSkin;
    }

    // Getter and Setter for ownerAccount
    public BankAccount getOwnerAccount() {
        return ownerAccount;
    }

    public void setOwnerAccount(BankAccount ownerAccount) {
        this.ownerAccount = ownerAccount;
    }

    // Getter and Setter for ownerName
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Getter and Setter for date
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    // Getter and Setter for cvv
    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    // Getter and Setter for cardNumberId
    public long getCardNumberId() {
        return cardNumberId;
    }

    public void setCardNumberId(long cardNumberId) {
        this.cardNumberId = cardNumberId;
    }

    // Getter and Setter for cardSkin
    public CardSkin getCardSkin() {
        return cardSkin;
    }

    public void setCardSkin(CardSkin cardSkin) {
        this.cardSkin = cardSkin;
    }


    //methods
    public String toString() {
        return String.valueOf(cardNumberId);
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Card)
            result = cardNumberId == ((Card) o).cardNumberId;
        return result;
    }

    public int hashCode() {
        return ownerAccount.hashCode();
    }

}