package com.example.noor_bank;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class entry {

    @FXML
    private Button login;
    @FXML
    private Button sign;
    @FXML
    private AnchorPane An;
    @FXML
    private AnchorPane AnR;
    @FXML
    private AnchorPane AnI;
    @FXML
    private AnchorPane AnL1;
    @FXML
    private AnchorPane AnB;
    @FXML
    private Label Lbut;
    @FXML
    private AnchorPane AnBut;
    @FXML
    private TextField name;
    @FXML
    private TextField dateOfBirth;
    @FXML
    private TextField id;
    @FXML
    private PasswordField pas;
    @FXML
    private PasswordField pas2;
    @FXML
    private TextField username;
    @FXML
    private TextField phonenumber;
    @FXML
    private Label ername;
    @FXML
    private Label erdateOfBirth;
    @FXML
    private Label erid;
    @FXML
    private Label erpas1;
    @FXML
    private Label erpas2;
    @FXML
    private Label erphone;
    @FXML
    private Label erusername;
    @FXML
    private TextField Lusername;
    @FXML
    private PasswordField Lpas;
    @FXML
    private Label erN;
    @FXML
    private Label erP;
    @FXML
    private TextField username2;
    @FXML
    private TextField id2;
    @FXML
    private Label er3N;
    @FXML
    private Label er3I;
    @FXML
    private Label erP1;
    @FXML
    private TextField Tepas1;
    @FXML
    private TextField textpas2;
    @FXML
    private TextField textpas;
    @FXML
    private Label infouser;
    @FXML
    private javafx.scene.control.TextArea infouser2;
    @FXML
    private  javafx.scene.control.TextArea infopas2;
    @FXML
    private Label infopas;
    @FXML
    private CheckBox ch1;
    @FXML
    private CheckBox ch2;
    @FXML
    private CheckBox ch3;
    @FXML
    private Label O1;
    @FXML
    private Label O2;
    @FXML
    private Button but3;
    @FXML
    private Button but4;
    @FXML
    private ImageView imageLogo;
    @FXML
    private Button back1;
    @FXML
    private Label Lforget;
    @FXML
    private Label er3I1;
    @FXML
    private Button login2;
    @FXML


    boolean temp1;
    boolean tpage = true;

    Control control = new Control();

    TranslateTransition translate1 = new TranslateTransition(Duration.millis(750), AnI);
    TranslateTransition translate2 = new TranslateTransition(Duration.millis(750), AnR);

    public void initialize(){
//        AnR.setLayoutX(An.getPrefWidth());
        AnR.setTranslateX(An.getPrefWidth()/2);
        AnL1.setTranslateX(-An.getPrefWidth()/2);
        AnI.setTranslateX(An.getPrefWidth()/4);
        AnB.setTranslateY(An.getPrefHeight());
        but4.setTranslateX(-AnI.getPrefWidth()*3/2);
        Lbut.setText("عضویت");

        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), AnI);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
//            TranslateTransition translate1 = new TranslateTransition(Duration.millis(1000), AnI);
            translate1.setNode(AnI);
            translate1.setFromX(240);
            translate1.setToX(0);
            translate1.play();
            TranslateTransition translate3 = new TranslateTransition(Duration.millis(750), but4);
            translate3.setToX(0);
            translate3.play();
//            TranslateTransition translate2 = new TranslateTransition(Duration.millis(1000), AnR);
            translate2.setNode(AnR);
            translate2.setFromX(480);
            translate2.setToX(0);
            translate2.play();
        }));
        timeline.play();

        infouser.setOnMouseEntered(event -> {
            infouser2.setVisible(true);
        });
        infouser.setOnMouseExited(event -> {
            infouser2.setVisible(false);
        });
        infopas.setOnMouseEntered(event -> {
            infopas2.setVisible(true);
        });
        infopas.setOnMouseExited(event -> {
            infopas2.setVisible(false);
        });

        An.heightProperty().addListener((observable, oldValue, newValue) -> {resize();});
        An.widthProperty().addListener((observable, oldValue, newValue) -> {resize();});

    }

    @FXML
    void exitApp(ActionEvent event){
        Noor.operator.closeTheApp();
    }

    public void resize(){


        AnR.setLayoutX(An.getWidth()/2);
        AnR.setPrefWidth(An.getWidth()/2);
        AnR.setPrefHeight(An.getHeight());

        AnL1.setPrefWidth(An.getWidth()/2);
        AnL1.setPrefHeight(An.getHeight());

        if(tpage){
            AnI.setLayoutX(0);
        }
        else {
            AnI.setLayoutX(An.getWidth()/2);
        }
        AnI.setPrefWidth(An.getWidth()/2);
        AnI.setPrefHeight(An.getHeight());

        AnB.setLayoutX(An.getWidth()/2);
        AnB.setPrefWidth(An.getWidth()/2);
        AnB.setPrefHeight(An.getHeight());



        name.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        name.setPrefWidth(AnL1.getPrefWidth()*5/8);
        name.setLayoutY(AnL1.getPrefHeight()*5/27);
        name.setPrefHeight(AnL1.getPrefHeight()/18);

        dateOfBirth.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        dateOfBirth.setPrefWidth(AnL1.getPrefWidth()*5/8);
        dateOfBirth.setLayoutY(AnL1.getPrefHeight()*5/27 +  AnL1.getPrefHeight()*11/108);
        dateOfBirth.setPrefHeight(AnL1.getPrefHeight()/18);

        id.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        id.setPrefWidth(AnL1.getPrefWidth()*5/8);
        id.setLayoutY(AnL1.getPrefHeight()*5/27+ 2*AnL1.getPrefHeight()*11/108);
        id.setPrefHeight(AnL1.getPrefHeight()/18);

        pas.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        pas.setPrefWidth(AnL1.getPrefWidth()*5/8);
        pas.setLayoutY(AnL1.getPrefHeight()*5/27 + 5*AnL1.getPrefHeight()*11/108);
        pas.setPrefHeight(AnL1.getPrefHeight()/18);

        textpas.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        textpas.setPrefWidth(AnL1.getPrefWidth()*5/8);
        textpas.setLayoutY(AnL1.getPrefHeight()*5/27 + 5*AnL1.getPrefHeight()*11/108);
        textpas.setPrefHeight(AnL1.getPrefHeight()/18);


        pas2.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        pas2.setPrefWidth(AnL1.getPrefWidth()*5/8);
        pas2.setLayoutY(AnL1.getPrefHeight()*5/27 + 6*AnL1.getPrefHeight()*11/108);
        pas2.setPrefHeight(AnL1.getPrefHeight()/18);

        textpas2.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        textpas2.setPrefWidth(AnL1.getPrefWidth()*5/8);
        textpas2.setLayoutY(AnL1.getPrefHeight()*5/27 + 6*AnL1.getPrefHeight()*11/108);
        textpas2.setPrefHeight(AnL1.getPrefHeight()/18);

        username.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        username.setPrefWidth(AnL1.getPrefWidth()*5/8);
        username.setLayoutY(AnL1.getPrefHeight()*5/27+ 4*AnL1.getPrefHeight()*11/108);
        username.setPrefHeight(AnL1.getPrefHeight()/18);

        phonenumber.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        phonenumber.setPrefWidth(AnL1.getPrefWidth()*5/8);
        phonenumber.setLayoutY(AnL1.getPrefHeight()*5/27 + 3*AnL1.getPrefHeight()*11/108);
        phonenumber.setPrefHeight(AnL1.getPrefHeight()/18);

        ername.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        ername.setPrefWidth(AnL1.getPrefWidth()*5/8);
        ername.setLayoutY(AnL1.getPrefHeight()/4 + 0*AnL1.getPrefHeight()*11/108);
        ername.setPrefHeight(AnL1.getPrefHeight()/36);

        erdateOfBirth.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        erdateOfBirth.setPrefWidth(AnL1.getPrefWidth()*5/8);
        erdateOfBirth.setLayoutY(AnL1.getPrefHeight()/4 + 1*AnL1.getPrefHeight()*11/108);
        erdateOfBirth.setPrefHeight(AnL1.getPrefHeight()/36);

        erid.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        erid.setPrefWidth(AnL1.getPrefWidth()*5/8);
        erid.setLayoutY(AnL1.getPrefHeight()/4 + 2*AnL1.getPrefHeight()*11/108);
        erid.setPrefHeight(AnL1.getPrefHeight()/36);

        erphone.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        erphone.setPrefWidth(AnL1.getPrefWidth()*5/8);
        erphone.setLayoutY(AnL1.getPrefHeight()/4 + 3*AnL1.getPrefHeight()*11/108);
        erphone.setPrefHeight(AnL1.getPrefHeight()/36);

        erpas1.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        erpas1.setPrefWidth(AnL1.getPrefWidth()*5/8);
        erpas1.setLayoutY(AnL1.getPrefHeight()/4 + 5*AnL1.getPrefHeight()*11/108);
        erpas1.setPrefHeight(AnL1.getPrefHeight()/36);

        erpas2.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        erpas2.setPrefWidth(AnL1.getPrefWidth()*5/8);
        erpas2.setLayoutY(AnL1.getPrefHeight()/4 + 6*AnL1.getPrefHeight()*11/108);
        erpas2.setPrefHeight(AnL1.getPrefHeight()/36);

        erusername.setLayoutX(AnL1.getPrefWidth()/2-name.getPrefWidth()/2);
        erusername.setPrefWidth(AnL1.getPrefWidth()*5/8);
        erusername.setLayoutY(AnL1.getPrefHeight()/4 + 4*AnL1.getPrefHeight()*11/108);
        erusername.setPrefHeight(AnL1.getPrefHeight()/36);


        Lusername.setLayoutX(AnR.getPrefWidth()/2-Lusername.getPrefWidth()/2);
        Lusername.setPrefWidth(AnR.getPrefWidth()*25/48);
        Lusername.setLayoutY(AnR.getPrefHeight()*19/54);
        Lusername.setPrefHeight(AnR.getPrefHeight()*7/108);

        Lpas.setLayoutX(AnR.getPrefWidth()/2-Lpas.getPrefWidth()/2);
        Lpas.setPrefWidth(AnR.getPrefWidth()*25/48);
        Lpas.setLayoutY(AnR.getPrefHeight()*19/54 + AnR.getPrefHeight()*7/54);
        Lpas.setPrefHeight(AnR.getPrefHeight()*7/108);

        Tepas1.setLayoutX(AnR.getPrefWidth()/2-Tepas1.getPrefWidth()/2);
        Tepas1.setPrefWidth(AnL1.getPrefWidth()*25/48);
        Tepas1.setLayoutY(AnR.getPrefHeight()*19/54 + AnR.getPrefHeight()*7/54);
        Tepas1.setPrefHeight(AnR.getPrefHeight()*7/108);

        login.setLayoutX(AnL1.getPrefWidth()/2-login.getPrefWidth()/2);
        login.setPrefWidth(AnR.getPrefWidth()*25/48);
        login.setLayoutY(AnR.getPrefHeight()*2/3);
        login.setPrefHeight(AnR.getPrefHeight()/18);

        sign.setLayoutX(AnL1.getPrefWidth()/2-sign.getPrefWidth()/2);
        sign.setPrefWidth(AnL1.getPrefWidth()*25/48);
        sign.setLayoutY(AnL1.getPrefHeight()*49/54);
        sign.setPrefHeight(AnL1.getPrefHeight()/18);

        ch1.setLayoutX(AnR.getPrefWidth()*25/96);
        ch1.setLayoutY(AnR.getPrefHeight()*9/18);

        ch2.setLayoutX(AnL1.getPrefWidth()*5/24);
        ch2.setLayoutY(AnR.getPrefHeight()*381/540);

        ch3.setLayoutX(AnL1.getPrefWidth()*5/24);
        ch3.setLayoutY(AnR.getPrefHeight()*436/540);

        O1.setLayoutX(AnR.getPrefWidth()/2-O1.getPrefWidth()/2);
        O1.setPrefWidth(AnR.getPrefWidth()*5/12);
        O1.setLayoutY(AnR.getPrefHeight()*5/27);
        O1.setPrefHeight(AnR.getPrefHeight()/10);

        O2.setLayoutX(AnL1.getPrefWidth()/2-O2.getPrefWidth()/2);
        O2.setPrefWidth(AnL1.getPrefWidth()*5/12);
        O2.setLayoutY(AnR.getPrefHeight()*5/108);
        O2.setPrefHeight(AnR.getPrefHeight()/10);

        infouser.setLayoutX(AnL1.getPrefWidth()*52/480);
        infouser.setLayoutY(AnR.getPrefHeight()*16/27);
        infouser.setPrefHeight(AnR.getPrefHeight()/18);
        infouser.setPrefWidth(AnL1.getPrefWidth()/16);

        infopas.setLayoutX(AnR.getPrefWidth()*52/480);
        infopas.setLayoutY(AnR.getPrefHeight()*25/36);
        infopas.setPrefHeight(AnR.getPrefHeight()/18);
        infopas.setPrefWidth(AnL1.getPrefWidth()/16);

        but3.setLayoutX(AnR.getPrefWidth()/2-but3.getPrefWidth()/2);
        but3.setPrefWidth(AnR.getPrefWidth()/6);
        but3.setLayoutY(AnR.getPrefHeight()*7/12);
        but3.setPrefHeight(AnR.getPrefHeight()/27);

        but4.setLayoutX(AnI.getPrefWidth()/2-but4.getPrefWidth()/2);
        but4.setPrefWidth(AnI.getPrefWidth()*5/12);
        but4.setLayoutY(AnR.getPrefHeight()*13/18);
        but4.setPrefHeight(AnR.getPrefHeight()*5/54);

        imageLogo.setLayoutX(AnI.getPrefWidth()*7/24);
        imageLogo.setLayoutY(AnR.getPrefHeight()*13/54);
        imageLogo.setFitWidth(AnI.getPrefWidth()*5/12);
        imageLogo.setFitHeight(AnI.getPrefHeight()*10/27);

        back1.setLayoutX(AnB.getPrefWidth()*19/24);
        back1.setLayoutY(AnB.getPrefHeight()*5/54);
        back1.setPrefHeight(AnB.getPrefHeight()*5/108);
        back1.setPrefWidth(AnB.getPrefWidth()*5/96);

        Lforget.setLayoutX(AnB.getPrefWidth()*3/16);
        Lforget.setLayoutY(AnB.getPrefHeight()*23/108);
        Lforget.setPrefHeight(AnB.getPrefHeight()*3/27);
        Lforget.setPrefWidth(AnB.getPrefWidth()*5/8);

        username2.setLayoutX(AnB.getPrefWidth()/2-username2.getPrefWidth()/2);
        username2.setLayoutY(AnB.getPrefHeight()*5/12);
        username2.setPrefHeight(AnB.getPrefHeight()*3/54);
        username2.setPrefWidth(AnB.getPrefWidth()*5/8);

        id2.setLayoutX(AnB.getPrefWidth()/2-id2.getPrefWidth()/2);
        id2.setLayoutY(AnB.getPrefHeight()*19/36);
        id2.setPrefHeight(AnB.getPrefHeight()*3/54);
        id2.setPrefWidth(AnB.getPrefWidth()*5/8);

        login2.setLayoutX(AnB.getPrefWidth()/2-login2.getPrefWidth()/2);
        login2.setLayoutY(AnB.getPrefHeight()*37/54);
        login2.setPrefHeight(AnB.getPrefHeight()*3/54);
        login2.setPrefWidth(AnB.getPrefWidth()*5/8);

        er3N.setLayoutX(AnB.getPrefWidth()/2-er3N.getPrefWidth()/2);
        er3N.setLayoutY(AnB.getPrefHeight()*13/27);
        er3N.setPrefHeight(AnB.getPrefHeight()/27);
        er3N.setPrefWidth(AnB.getPrefWidth()*5/8);

        er3I.setLayoutX(AnB.getPrefWidth()/2-er3I.getPrefWidth()/2);
        er3I.setLayoutY(AnB.getPrefHeight()*65/108);
        er3I.setPrefHeight(AnB.getPrefHeight()/27);
        er3I.setPrefWidth(AnB.getPrefWidth()*5/8);

        infouser2.setLayoutX(infouser.getLayoutX()+infouser.getPrefWidth()*4/5);
        infouser2.setLayoutY(infouser.getLayoutY()-infouser2.getPrefHeight()*4/5);

        infopas2.setLayoutX(infopas.getLayoutX()+infopas.getPrefWidth()*2/3);
        infopas2.setLayoutY(infopas.getLayoutY()-infopas2.getPrefHeight()*9/10);
    }

    public void but()  {
        if(tpage){
            tpage = false;
            pageLogin();
        }
        else{
            tpage = true;
            pageSign();
        }
    }

    public void pageSign(){
        Lbut.setText("عضویت");
        //            TranslateTransition translate1 = new TranslateTransition(Duration.millis(1000), AnI);
        AnI.setLayoutX(0);
        translate1.setNode(AnI);
        translate1.setFromX(An.getWidth()/2);
        translate1.setToX(0);
        translate1.play();
//            TranslateTransition translate2 = new TranslateTransition(Duration.millis(1000), AnR);
        translate2.setNode(AnR);
        translate2.setFromX(An.getWidth()/2);
        translate2.setToX(0);
        translate2.play();
    }

    public void pageLogin(){
        Lbut.setText("ورود");
        TranslateTransition translate1 = new TranslateTransition(Duration.millis(750), AnI);
        AnI.setLayoutX(An.getWidth()/2);
        translate1.setFromX(-An.getWidth()/2);
        translate1.setToX(0);
        translate1.play();
//            TranslateTransition translate2 = new TranslateTransition(Duration.millis(1000), AnL1);
        translate2.setNode(AnL1);
        translate2.setFromX(-An.getWidth()/2);
        translate2.setToX(0);
        translate2.play();
    }
    String tt1 = "";
    public void login(ActionEvent event) throws Exception {
        if(Lpas.isVisible()){
            tt1 = Lpas.getText();
        }
        else {
            tt1 = Tepas1.getText();
        }
        String[] error=Noor.serverSideOperator.checkLogIn(Lusername.getText(),tt1);
        if(error[0].equals("enter")){
            Noor.operator.goTo("chooseBankAccount",event);
        }else{
            erP1.setText(error[0]);
            erN.setText(error[1]);
            erP.setText(error[2]);
            Lusername.clear();
            Lpas.clear();
            Tepas1.clear();
        }
    }

    String tt2 = "";
    String tt3 = "";
    public void signIN(ActionEvent event){
        //
        if(pas.isVisible()){
            tt2 = pas.getText();
        }else {
            tt2 = textpas.getText();
        }
        if (pas2.isVisible()){
            tt3 = pas2.getText();
        }else {
            tt3 = textpas2.getText();
        }
        //
        String[] error = Noor.serverSideOperator.accountSignUp(username.getText(),tt2,tt3, name.getText(), dateOfBirth.getText(),id.getText(),phonenumber.getText());
        if(error[0]==null){
            Noor.operator.goTo("chooseBankAccount",event);
        }else {
            System.out.println(error[0]);
            ername.setText(error[1]);
            if (error[1]!=null)
                name.clear();
            erusername.setText(error[2]);
            if (error[2]!=null)
                username.clear();
            erpas1.setText(error[3]);
            if (error[3]!=null) {
                pas.clear();
                textpas.clear();
            }
            erpas2.setText(error[4]);
            if (error[4]!=null){
                pas2.clear();
                textpas2.clear();
            }
            erid.setText(error[5]);
            if (error[5]!=null)
                id.clear();
            erphone.setText(error[6]);
            if (error[6]!=null)
                phonenumber.clear();
            erdateOfBirth.setText(error[7]);
            if (error[7]!=null)
                dateOfBirth.clear();
        }
    }

    public void login2(ActionEvent event) throws Exception{
        String[] error=Noor.serverSideOperator.checkLogInF(username2.getText(),id2.getText());
        if(error[0].equals("enter")){
            Noor.operator.goTo("chooseBankAccount",event);
        }else{
            System.out.println(error[0]);
            er3I1.setText(error[0]);
            er3N.setText(error[1]);
            er3I.setText(error[2]);
            username2.clear();
            id2.clear();
        }
    }

    public void forgetbut(){
        TranslateTransition translate1 = new TranslateTransition(Duration.millis(750), AnR);
        TranslateTransition translate2 = new TranslateTransition(Duration.millis(750), AnB);
//        translate1.setNode(AnR);
        translate1.setFromY(0);
        translate1.setFromX(0);
        translate1.setToY(-An.getHeight());
        translate1.setOnFinished(event -> {
            AnR.setTranslateY(-960);
        });
//        translate2.setNode(AnB);
        translate2.setFromY(An.getHeight());
        translate2.setFromX(0);
        translate2.setToY(0);
        translate1.play();
        translate2.play();
    }

    public  void back1(){
        TranslateTransition translate1 = new TranslateTransition(Duration.millis(750), AnR);
        TranslateTransition translate2 = new TranslateTransition(Duration.millis(750), AnB);
//        translate1.setNode(AnR);
        translate1.setFromY(-An.getHeight());
        translate1.setFromX(0);
        translate1.setToY(0);
//        translate2.setNode(AnB);
        translate2.setFromY(0);
        translate2.setFromX(0);
        translate2.setToY(An.getHeight());
        translate1.play();
        translate2.play();
    }

    String temp4 = "";
    public void checkBox1(){
        if(Lpas.isVisible()){
            Lpas.setVisible(false);
            temp4 = Lpas.getText();
            Tepas1.setText(temp4);
        }
        else {
            Lpas.setVisible(true);
            temp4 = Tepas1.getText();
            Lpas.setText(temp4);
        }
    }

    String temp5 = "";
    public void checkbox2(){
        if(pas.isVisible()){
            pas.setVisible(false);
            temp5 = pas.getText();
            textpas.setText(temp5);
        }
        else {
            pas.setVisible(true);
            temp5 = textpas.getText();
            pas.setText(temp5);
        }
    }
    String temp6 = "";
    public void checkbox3(){
        if(pas2.isVisible()){
            pas2.setVisible(false);
            temp6 = pas2.getText();
            textpas2.setText(temp6);
        }
        else {
            pas2.setVisible(true);
            temp6 = textpas2.getText();
            pas2.setText(temp6);
        }
    }
}