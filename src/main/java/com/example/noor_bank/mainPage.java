package com.example.noor_bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class mainPage {

    @FXML
    private Label A_accountNumberId;

    @FXML
    private Label A_accountType;

    @FXML
    private Label A_name;

    @FXML
    private Label A_shaba;

    @FXML
    private Label C_cardNumber;

    @FXML
    private Label C_cardOwner;

    @FXML
    private Label appBalance;

    @FXML
    private Label C_cvv2;

    @FXML
    private Label C_exp;

    @FXML
    private Button T_acountNumber;

    @FXML
    private Button T_cardNumber;

    @FXML
    private Label T_dName;

    @FXML
    private Label T_error;

    @FXML
    private Button T_shaba;

    @FXML
    private TextField T_field;

    @FXML
    private TextField T_moneyField;

    @FXML
    private Label T_total;

    @FXML
    private Label T_warning;

    @FXML
    private Button ST;

    @FXML
    private Button CT;

    @FXML
    private Label T_trasferOption;

    @FXML
    private AnchorPane accountManagerTab;

    @FXML
    private AnchorPane cardManagerTab;

    @FXML
    private Button closeBalance;

    @FXML
    private Button openBalance;

    @FXML
    private AnchorPane serviseTab;

    @FXML
    private AnchorPane transferTab;

    long balance;
    Account account;
    BankAccount bankAccount;
    Card card;
    int transferMode=1;
    BankAccount T_target;

    @FXML
    void initialize() {
        account = Noor.operator.getCurrentAccount();
        bankAccount = Noor.operator.getCurrentBankAccount();
        card = Noor.operator.getCurrentBankAccount().getCards();
        //
        T_field.setOnKeyReleased(e-> searchForTrancfer());
        T_moneyField.setOnKeyReleased(e-> amountToString());
        //loading
        A_name.setText(account.getNameAndLastName());
        A_shaba.setText(bankAccount.getShaba());
        A_accountNumberId.setText(String.valueOf(bankAccount.getAccountNumberId()));
        String temp;
        if(bankAccount instanceof GharzOlHasaneJariAccount){
            temp = "قرض الحسنه ی جاری";
        } else if (bankAccount instanceof LongTermInvestmentAccount) {
            temp = "سپرده بلند مدت";
            CT.setDisable(true);
            ST.setDisable(true);
            T_warning.setVisible(true);
        }else{
            temp = "سپرده کوتاه مدت";
        }
        A_accountType.setText(temp);
        balance = bankAccount.getBalance();
        C_cvv2.setText("CVV2:"+card.getCvv());
        int exp = card.getDate();
        C_exp.setText("EXP:"+exp/1_00_00+"/"+(exp/1_00)%1_00);
        C_cardNumber.setText(String.valueOf(card.getCardNumberId()));
        C_cardOwner.setText(card.getOwnerName());
    }

    @FXML
    void accountChangeInfo(ActionEvent event) {
        Noor.operator.goTo("editinfo",event);
    }

    @FXML
    void accountChangePassword(ActionEvent event) {

    }

    @FXML
    void accountLogOut(ActionEvent event) {
        Noor.operator.goTo("entry",event);
    }

    @FXML
    void bill(ActionEvent event) {

    }

    @FXML
    void box(ActionEvent event) {

    }

    @FXML
    void buyInternet(ActionEvent event) {

    }

    @FXML
    void car(ActionEvent event) {

    }

    @FXML
    void cardForgetPassword(ActionEvent event) {

    }

    @FXML
    void changeAccount(ActionEvent event) {
        Noor.operator.goTo("chooseBankAccount",event);
    }

    @FXML
    void changeCard(ActionEvent event) {

    }

    @FXML
    void changeCardPassword(ActionEvent event) {

    }

    @FXML
    void changeTab(ActionEvent event) {
        double id = ((Button) event.getSource()).getLayoutY();
        if(id==288){
            accountManagerTab.setVisible(false);
            transferTab.setVisible(true);
            cardManagerTab.setVisible(false);
            serviseTab.setVisible(false);
        } else if (id == 144) {
            accountManagerTab.setVisible(false);
            transferTab.setVisible(false);
            cardManagerTab.setVisible(false);
            serviseTab.setVisible(true);
        } else if (id == 432) {
            accountManagerTab.setVisible(false);
            transferTab.setVisible(false);
            cardManagerTab.setVisible(true);
            serviseTab.setVisible(false);
        }else{
            accountManagerTab.setVisible(true);
            transferTab.setVisible(false);
            cardManagerTab.setVisible(false);
            serviseTab.setVisible(false);
        }
    }

    @FXML
    void changeTrasferOption(ActionEvent event) {
        double y = ((Button) event.getSource()).getLayoutY();
        if(y==50.4){
            transferMode=1;
            T_trasferOption.setText("شماره کارت:");
        } else if (y==170.4) {
            transferMode=2;
            T_trasferOption.setText("شماره حساب:");
        }else{
            transferMode=3;
            T_trasferOption.setText("شماره شبا:");
        }
    }

    @FXML
    void charety(ActionEvent event) {

    }

    @FXML
    void chargePhone(ActionEvent event) {

    }

    @FXML
    void clossAccount(ActionEvent event) {

    }

    @FXML
    void deactiveCard(ActionEvent event) {

    }

    @FXML
    void exitApp(ActionEvent event) {
        Noor.operator.closeTheApp();
    }

    @FXML
    void hideBalance(ActionEvent event) {
        balance=bankAccount.getBalance();
        char id = ((Button) event.getSource()).getId().charAt(0);
        if(id == 'o'){
            openBalance.setVisible(false);
            closeBalance.setVisible(true);
            appBalance.setText(String.format("%,d ريال",balance));
        }else{
            openBalance.setVisible(true);
            closeBalance.setVisible(false);
            appBalance.setText("*** ريال");
        }
    }

    @FXML
    void history(ActionEvent event) {
        Noor.operator.goTo("bill",event);
    }

    @FXML
    void invite(ActionEvent event) {

    }

    @FXML
    void loan(ActionEvent event) {

    }

    @FXML
    void shutDownCard(ActionEvent event) {

    }

    @FXML
    void suport(ActionEvent event) {

    }

    @FXML
    void transfer(ActionEvent event) {
        if(T_target == null){
            T_error.setText("فرد یافت نشد");
        }else{
            try {
                Noor.operator.getCurrentBankAccount().spendBalance(Long.parseLong(T_moneyField.getText()));
                T_target.addToBalance(Long.parseLong(T_moneyField.getText()));
                T_error.setText("تراکنش موفق");
            } catch (NotEnoughMoney e) {
                T_error.setText("پول نداری");
            }
        }
    }

    void amountToString() {
        StringBuilder result = new StringBuilder();
        int i=0;
        String[] yakab = {"", "یک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه"};
        String[] sadegan = {"", "صد", "دویست", "سیصد", "چهارصد", "پانصد", "شانصد", "هفتصد", "هشتصد", "نهصد"};
        String[] dahegan = {"", "ده", "بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود"};
        String[] es = {"یازده", "دوازده", "سیزده", "چهارده", "پانزده", "شانزده", "هوده", "هجده", "نوزده"};
        String[] adad = {"","هزار","ملیون","ملیارد"};
        if(T_moneyField.getText().isEmpty()){
            T_total.setText(" ");
        }else {
            long scan = Long.parseLong(T_moneyField.getText());
            int length = T_moneyField.getText().length();
            //
            int adadAmount = length / 3;
            if (length % 3 != 0)
                adadAmount++;
            //
            if (length > 12) {
                result.append("زیاد");
            } else {
                while (scan > 0) {
                    long x = scan;
                    long counter = 1;
                    while (x >= 1000) {
                        x /= 1000;
                        counter *= 1000;
                    }
                    int temp = (int) (x / 100);
                    result.append(sadegan[temp]);
                    if (x % 100 > 9 && x / 100 != 0) {
                        result.append(" و ");
                    }
                    if (x - (temp * 100) > 10 && x - (temp * 100) < 20) {
                        temp = (int) ((x % 10) - 1);
                        result.append(es[temp]);
                    } else {
                        temp = (int) ((x - (temp * 100)) / 10);
                        result.append(dahegan[temp]);
                        if (x % 10 != 0 && x / 10 != 0) {
                            result.append(" و ");
                        }
                        temp = (int) (x % 10);
                        result.append(yakab[temp]);
                    }
                    if (--adadAmount >= 1)
                        result.append(" " + adad[adadAmount]);
                    scan %= counter;
                    while (counter>=1000&& scan==scan%(counter/1000)){
                        adadAmount--;
                        counter/=1000;
                        scan %= counter;
                    }
                    if (adadAmount >= 1)
                        result.append(" و ");
                }
            }
            T_total.setText(result.toString()+ " ريال");
        }
    }
    public void searchForTrancfer(){
        String result;
        String in=T_field.getText();
        if(transferMode ==1){
            if(in.length()==16){
                if(Noor.serverSideOperator.getBankAccounts().stream().map(o->o.getCards().getCardNumberId()).anyMatch(o->o==Long.parseLong(in))){
                    T_target = Noor.serverSideOperator.getBankAccounts().stream().filter(o->o.getCards().getCardNumberId()==Long.parseLong(in)).findAny().get();
                    result=T_target.getOwner().getNameAndLastName();
                }else{
                    result = "فرد یافت نشد";
                    T_target = null;
                }
            }else{
                result = "ورودی غیر مجاز";
                T_target = null;
            }
        } else if (transferMode ==2) {
            if(in.length()==12){
                if(Noor.serverSideOperator.getBankAccounts().stream().map(o->o.getAccountNumberId()).anyMatch(o->o==Long.parseLong(in))){
                    T_target = Noor.serverSideOperator.getBankAccounts().stream().filter(o->o.getAccountNumberId()==Long.parseLong(in)).findAny().get();
                    result=T_target.getOwner().getNameAndLastName();
                }else{
                    result = "فرد یافت نشد";
                    T_target = null;
                }
            }else{
                result = "ورودی غیر مجاز";
                T_target = null;
            }
        }else{
            if(in.length()==26&&in.charAt(0)!='I'&&in.charAt(1)!='R'){
                if(Noor.serverSideOperator.getBankAccounts().stream().map(o->o.getShaba()).anyMatch(o->o.equals(in))){
                    T_target = Noor.serverSideOperator.getBankAccounts().stream().filter(o->o.getShaba().equals(in)).findAny().get();
                    result=T_target.getOwner().getNameAndLastName();
                }else{
                    result = "فرد یافت نشد";
                    T_target = null;
                }
            }else{
                result = "ورودی غیر مجاز";
                T_target = null;
            }
        }
        T_dName.setText(result);
    }
}
