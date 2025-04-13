package com.example.noor_bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ChooseBankAccount {

    @FXML
    private Label error;
    private Account account;
    private BankAccount garz;
    private BankAccount longTerm;
    private BankAccount shortTerm;

    @FXML
    void initialize(){
        account=Noor.operator.getCurrentAccount();
        for (BankAccount bankAccount : account.getAccountsList()) {
            if(bankAccount instanceof GharzOlHasaneJariAccount){
                garz=bankAccount;
            } else if (bankAccount instanceof LongTermInvestmentAccount) {
                longTerm=bankAccount;
            } else if (bankAccount instanceof ShortTermInvestmentAccount) {
                shortTerm=bankAccount;
            }
        }
    }

    @FXML
    void back(ActionEvent event) {
        Noor.operator.goBack(event);
    }

    @FXML
    void chooseBankAccount(ActionEvent event) {
        double x = ((Button) event.getSource()).getLayoutX();
        if(x==880){
            if(garz!=null){
                Noor.operator.setCurrentBankAccount(garz);
                Noor.serverSideOperator.setCurrentBankAccount(garz);
                Noor.operator.goTo("mainPage",event);
            }else {
                error.setText("حساب نداری");
            }
        } else if (x >= 480&&x<=500) {
            if(longTerm!=null){
                Noor.operator.setCurrentBankAccount(longTerm);
                Noor.serverSideOperator.setCurrentBankAccount(longTerm);
                Noor.operator.goTo("mainPage",event);
            }else {
                error.setText("حساب نداری");
            }
        }else{
            if(shortTerm!=null){
                Noor.operator.setCurrentBankAccount(shortTerm);
                Noor.serverSideOperator.setCurrentBankAccount(shortTerm);
                Noor.operator.goTo("mainPage",event);
            }else {
                error.setText("حساب نداری");
            }
        }
    }

    @FXML
    void createBankAccount(ActionEvent event) {
        double x = ((Button) event.getSource()).getLayoutX();
        if(x==956){
            if(garz==null){
                garz=new GharzOlHasaneJariAccount(account);
                account.getAccountsList().add(garz);
                Noor.operator.setCurrentBankAccount(garz);
                Noor.serverSideOperator.setCurrentBankAccount(garz);
                Noor.operator.goTo("mainPage",event);
            }else {
                error.setText("حساب داری");
            }
        } else if (x == 568) {
            if(longTerm==null){
                longTerm=new LongTermInvestmentAccount(account);
                account.getAccountsList().add(longTerm);
                Noor.operator.setCurrentBankAccount(longTerm);
                Noor.serverSideOperator.setCurrentBankAccount(longTerm);
                Noor.operator.goTo("mainPage",event);
            }else {
                error.setText("حساب داری");
            }
        }else{
            if(shortTerm==null){
                shortTerm=new ShortTermInvestmentAccount(account);
                account.getAccountsList().add(shortTerm);
                Noor.operator.setCurrentBankAccount(shortTerm);
                Noor.serverSideOperator.setCurrentBankAccount(shortTerm);
                Noor.operator.goTo("mainPage",event);
            }else {
                error.setText("حساب داری");
            }
        }
    }

}
