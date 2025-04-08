package com.example.noor_bank;

public class NotEnoughMoney extends Exception {
    public NotEnoughMoney(String message) {
        super(message);
    }

    public NotEnoughMoney() {
        super("message");
    }
}
