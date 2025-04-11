package com.example.noor_bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button T_shaba;

    @FXML
    private Label T_total;

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

    @FXML
    void initialize() {
        balance=1_000_000_000;
    }

    @FXML
    void accountChangeInfo(ActionEvent event) {

    }

    @FXML
    void accountChangePassword(ActionEvent event) {

    }

    @FXML
    void accountLogOut(ActionEvent event) {

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

    }

}
