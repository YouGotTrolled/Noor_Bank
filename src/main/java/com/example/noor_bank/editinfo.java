package com.example.noor_bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.stream.Collectors;

public class editinfo {

    @FXML
    private TextField dateOfBirth;

    @FXML
    private Label dateOfBirthError;

    @FXML
    private TextField id;

    @FXML
    private Label idError;

    @FXML
    private TextField nameAndLastName;

    @FXML
    private Label nameAndLastNameError;

    @FXML
    private TextField password;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Label passwordError;

    @FXML
    private Label phoneNumberError;

    @FXML
    private TextField rePassword;

    @FXML
    private Label rePasswordError;

    @FXML
    private void initialize() {
        load(Noor.operator.getCurrentAccount());
    }

    @FXML
    void back(ActionEvent event) {
        Noor.operator.goBack(event);
    }

    @FXML
    void submit(ActionEvent event) {
        String[] errors = Noor.serverSideOperator.editAccount(Noor.operator.getCurrentAccount(), password.getText(), nameAndLastName.getText(), dateOfBirth.getText(), id.getText(), phoneNumber.getText());
        if(errors[0]==null){
            nameAndLastName.clear();
            password.clear();
            dateOfBirth.clear();
            id.clear();
            phoneNumber.clear();
            Noor.operator.goBack(event);
        }else{
        /*
        0_allError
        1_nameError
        2_passwordError
        3_idError
        4_phoneNumberError
        5_dateOfBirstError
        */
            System.out.println(errors[0]);
            nameAndLastNameError.setText(errors[1]);
            if (errors[1]!=null)
                nameAndLastName.clear();
            passwordError.setText(errors[2]);
            if (errors[2]!=null)
                password.clear();
            idError.setText(errors[3]);
            if (errors[3]!=null)
                id.clear();
            phoneNumberError.setText(errors[4]);
            if (errors[4]!=null)
                phoneNumber.clear();
            dateOfBirthError.setText(errors[5]);
            if (errors[7]!=null)
                dateOfBirth.clear();
        }
    }void load(Account ali){
        nameAndLastName.setText(ali.getNameAndLastName());
        password.setText(ali.getPassword());
        phoneNumber.setText("0"+ali.getPhoneNumber());
        id.setText(String.valueOf(ali.getId()));
        int date=ali.getDateOfBirth();
        dateOfBirth.setText(date/10000+"/"+(date/100)%100+"/"+date%100);
    }

}
