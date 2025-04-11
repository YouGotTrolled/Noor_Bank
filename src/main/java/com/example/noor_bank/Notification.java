package com.example.noor_bank;

import java.io.Serializable;

public class Notification implements Serializable {
    private static final long serialVersionUID = 1;
    private String message;
    private boolean read;

    //constructor
    public Notification(String message, boolean read) {
        this.message = message;
        this.read = read;
    }

    public Notification(String message) {
        this(message, false);
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter and Setter for dateOfBirth
    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    //methods
    public String toString() {
        return message + "(" + read + ")";
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Notification)
            result = message.equals(((Notification) o).message);
        return result;
    }

    public int hashCode() {
        return message.hashCode();
    }
}