package com.example.noor_bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.FileReader;

public class Bill {

    @FXML
    private TextArea area;

    BankAccount bankAccount;
    Account account;

    @FXML
    void initialize() {
        account= Noor.operator.getCurrentAccount();
        bankAccount = Noor.operator.getCurrentBankAccount();
        try(BufferedReader reader = new BufferedReader(new FileReader(bankAccount.getBill().getAbsolutePath()))){
            String temp = reader.readLine();
            while (temp!=null){
                area.appendText(temp);
                temp = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) {
        Noor.operator.goBack(event);
    }


}
