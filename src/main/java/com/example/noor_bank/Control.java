package com.example.noor_bank;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.StringTokenizer;

public class Control {

    private String name;
    private String lastname;
    private String username;
    private String password;
    private String id;
    private String phonenumber;

    private boolean t1name = false;
    private boolean t1lastname = false;
    private boolean t1username = false;
    private boolean t1password = false;
    private boolean t1id = false;
    private boolean t1phonenumber = false;

    private boolean t2name = true;
    private boolean t2lastname = true;
    private boolean t2username = true;
    private boolean t2password = false;
    private boolean t2id = true;
    private boolean t2phonenumber = true;

    private boolean t3username = true;
    private boolean t3password = true;

    private boolean t4password = true;

    private boolean temp1 = false;
    private boolean temp2 = false;
    private boolean temp3 = false;



    public static class user extends Control{

    }

    private boolean TPass = false;
    private boolean Texists = false;
    private boolean Tid = false;
    private boolean Tnull = false;

    int errore ;
    int error2;

    public boolean checkLoginuser(String Lusername , String Lpas) {

        TPass = false;
        Texists = false;
        Tid = false;
        Tnull = false;

        if(Lusername != "") {
            Tnull = true;
            File ff = new File(".\\users\\" + Lusername);
            if (ff.exists()) {
                Texists = true;
                try {
                    BufferedReader br = new BufferedReader(new FileReader(".\\users\\" + Lusername + "\\info.txt"));
                    String temp = "";
                    for (int i = 0; i < 3; i++) {
                        temp = br.readLine();
                    }
                    StringTokenizer tokenizer = new StringTokenizer(br.readLine(), ":");
                    String temp2 = tokenizer.nextToken();
                    if (Lpas.equals(tokenizer.nextToken())) {
                        TPass = true;
                        return true;
                    }
                    tokenizer = new StringTokenizer(br.readLine(), ":");
                    String temp3 = tokenizer.nextToken();
                    if (Lpas.equals(tokenizer.nextToken())) {
                        Tid = true;
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public int errorcheckLoginuser(){
        error2 = 0;
        if(!Tnull){
            error2 = 1;
        }
        else if(!Texists){
            //حسابی با این نام کاربری وجود ندارد
            error2 = 2;
        }
        else if (!TPass||!Tid){
            // رمز عبور اشتباه است
            error2 = 3;
        }
//        else if(!Tid){
//            //کد ملی اشتباه است
//            error2 = ;
//        }
        //   0 : خطای ناشناخته
        return error2;
    }


    public boolean checknewuser(String name , String lastname , String username, String phonenumber, String id, String password , String password2) {

        t1name = false;
        t1lastname = false;
        t1username = false;
        t1password = false;
        t1id = false;
        t1phonenumber = false;

        t2name = true;
        t2lastname = true;
        t2username = true;
        t2password = false;
        t2id = true;
        t2phonenumber = true;

        t3username = true;
        t3password = true;

        t4password = true;

        temp1 = false;
        temp2 = false;
        temp3 = false;

//        this.name = name;
//        this.lastname = lastname;
//        this.username = username;
//        this.password = password;
//        this.age = age;
//        this.phonenumber = phonenumber;
        //بررسی فارسی بودن و خالی نبودن نام
        if(name!= "" ) {
            t1name = true;
            for (int i = 0; i < name.length(); i++) {
                if (!((name.charAt(i) <= ('\u06FF') && name.charAt(i) >= ('\u0600')) || name.charAt(i) == ('\u200C') || Character.isWhitespace(name.charAt(i)))) {
                    t2name = false;
                }
            }
        }
        if(lastname != "") {
            t1lastname = true;
            for (int i = 0; i < lastname.length(); i++) {
//                System.out.println(lastname.length());
//                System.out.println(lastname.charAt(i));
                if (!(( lastname.charAt(i) <= ('\u06FF') && lastname.charAt(i) >= ('\u0600')) || lastname.charAt(i) == ('\u200C') || Character.isWhitespace(name.charAt(i)))){
                    t2lastname = false;
                }
            }
        }
        //حروف انگلیسی بزرگ و کوچک و نقطه و @ و # مجاز است
        if(username != "") {
            t1username = true;
            for (int i = 0; i < username.length(); i++) {
                if(!((username.charAt(i) >= ('A') && username.charAt(i) <= ('Z'))||(username.charAt(i) >= ('a') && username.charAt(i) <= ('z'))||username.charAt(i) == ('.')||username.charAt(i) == ('@')||username.charAt(i) == ('#'))){
                    t2username = false;
                }
            }
        }
        // رمز از حروف کوچک و بزرگ انگلیسی ، عدد تشکیل شده است
        if(password != "") {

            t1password = true;
            for (int i = 0; i < password.length(); i++) {
                if((password.charAt(i) >= ('a') && password.charAt(i) <= ('z'))||(password.charAt(i) >= ('A') && password.charAt(i) <= ('Z'))||(password.charAt(i) >= ('0') && password.charAt(i) <= ('9'))) {
                    if (password.charAt(i) >= ('a') && password.charAt(i) <= ('z')) {
                        temp1 = true;
                    }
                    if (password.charAt(i) >= ('A') && password.charAt(i) <= ('Z')) {
                        temp2 = true;
                    }
                    if (password.charAt(i) >= ('0') && password.charAt(i) <= ('9')) {
                        temp3 = true;
                    }
                }
                else {
                    t4password = false;
                }
            }
            if(temp1 && temp2 && temp3){
                t2password = true;
            }
            if(!(password.equals(password2))){
                t3password = false;
            }
        }
        //کد ملی باید 10 رقمی باشد
        if(id != "" ){
            t1id = true;
            if(id.length()==10) {
                for (int i = 0; i < 10; i++) {
                    if (!((id.charAt(i) >= '0') && (id.charAt(i) <= '9'))) {
                        System.out.println("دو");
                        t2id = false;
                    }
                }
            }
            else {
                t2id = false;
            }
        }
        //تلفن همراه باید 11 رقمی باشد
        if(phonenumber!= ""){
            t1phonenumber = true;
            if(phonenumber.length()==11) {
                for (int i = 0; i < 11; i++) {
                    if (!(phonenumber.charAt(i) >= '0' && phonenumber.charAt(i) <= '9')) {
                        System.out.println("یک");
                        t2phonenumber = false;
                    }
                }
            }
            else {
                t2phonenumber = false;
            }
        }

        //باید فایل ادمین ها را هم بررسی کند
        if (t1username && t2username) {
            File check = new File(".\\users\\"+ username );
            if (check.exists()) {
                //نام کاربری تکراری است
                t3username = false;
            }
        }

        if(t1name && t2name && t1lastname && t2lastname && t1username && t2username && t3username && t1id && t2id && t1phonenumber && t2phonenumber && t1password && t2password && t3password && t4password) {
            this.name = name;
            this.lastname = lastname;
            this.username = username;
            this.password = password;
            this.id = id ;
            this.phonenumber = phonenumber;

            return true;
        }
        return false;
    }

    public int erroreNewuser() {
        errore = 10000000;

        if(!t1name){
            //
            //فیلد خالی است
            errore = errore + 9 ;
        }
        else if (!t2name){
            //فقط حروف فارسی مجاز است
            errore = errore + 1 ;
        }


        if(!t1lastname){
            //فیلد خالی است
            //
            errore = errore+90;
        }
        else if (!t2lastname){
            // فقط حروف فارسی مجاز است
            errore = errore+10;
        }


        if(!t1username){
            //فیلد خالی است
            //
            errore = errore+900;
        }
        else if (!t2username){
            // نام کاربری حروف کوچک و بزرگ انگلیسی دات @ # مجاز است
            errore = errore+100;
        }
        else if (!t3username){
            // نام کاربری تکراری است
            errore = errore+200;
        }


        if (!t1password){
            // فیلد خالی است
            errore = errore+9000;
        }
        else if(!t4password){
            //فقط حروف بزرگ و کوچک انگلیسی و عدد مجاز است
            errore = errore+8000;
        }
        else if (!t2password){
            //رمز درست ساخته نشده است
            if(!temp1){
                //  حروف کوچک انگلیسی ندارد
                errore = errore+1000;
            }
            if(!temp2){
                //  حروف بزرگ انگلیسی ندارد
                errore = errore+2000;
            }
            if(!temp3){
                //  عدد ندارد
                errore = errore+4000;
            }

            // 1 : حروف کوچک انگلیسی ندارد
            // 2 : حروف ببزرگ انگلیسی ندارد
            // 4 : عدد ندارد

            // 5 : عدد و حروف کوچک انگلیسی ندارد
            // 3 : حروف کوچک و بزرگ انگلیسی ندارد
            // 6 : عدد و حروف بزرگ انگلیسی ندارد
            // 7 عدد و حروف کوچک و بزرگ انگلیسی ندارد
        }


        if (!t1id){
            // فیلد خالی است
            errore = errore+90000;
        }
        else if (!t2id){
            // کد ملی را درست وارد کنید(اعداد باشد)
            errore = errore+10000;
        }


        if (!t1phonenumber){
            //فیلد خالی است
            errore = errore+900000;
        }
        else if(!t2phonenumber){
            //شماره همراه را درست وارد کنید
            errore = errore+100000;
        }

        if (!t3password){
            errore = errore + 9000000;
        }
        // 3 : رمز و تکرار رمز یکی نیست

        return (errore);
    }



    public void sign(){
        try{
            //ایجاد پوشه و دسته بندی برای کاربر
            File user = new File(".\\users\\" + username);
            user.mkdir();
            File user1 = new File(".\\users\\" + username + "\\info.txt");
            user1.createNewFile();
            File user2 = new File(".\\users\\" + username + "\\accounts");
            user2.mkdir();
            File user3 = new File(".\\users\\" + username + "\\communication");
            user3.mkdir();
            File user4 = new File(".\\users\\" + username + "\\history.txt");
            user4.createNewFile();
            PrintWriter pw = new PrintWriter(user1);
            pw.println("name:"+name+"\nlastname:"+lastname+"\nusername:"+username+"\npassword:"+password+"\nid:"+id+"\nphonenumber:"+phonenumber);
            pw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void changePage(javafx.event.ActionEvent event) throws Exception{
        System.out.println("AA");
//        FXMLLoader ld = new FXMLLoader(getClass().getResource("root2.fxml"));
//        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Parent root = ld.load();
//        Scene scene = new Scene(root);
//        stg.setScene(scene);
//        stg.show();
    }
    //
    //
    //
    //
    //
    //
    //
    //
    public static class rootnewAcount extends Control {

    }
    //    public static boolean   newAcount(String typeAcount) {
//        return true;
//    }
    public boolean newAcount(String typeAcount, String secondPerson) {


        return true;
    }



}


