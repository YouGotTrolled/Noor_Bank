package com.example.noor_bank;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerSideOperator {
    private BankAccount currentBankAccount;
    private Account currentAccount;
    private ExecutorService dailyChecker;
    private List<BankAccount> bankAccounts;
    private List<Account> accounts;

    //constructor
    public ServerSideOperator(){
        ExecutorService dailyChecker = Executors.newSingleThreadExecutor();
        bankAccounts = new ArrayList<>();
        accounts = new ArrayList<>();
        loadAllAccounts();
        startDailyCheck();
    }

    // Getter and Setter for currentBankAccount
    public BankAccount getCurrentBankAccount() {
        return currentBankAccount;
    }

    public void setCurrentBankAccount(BankAccount currentBankAccount) {
        this.currentBankAccount = currentBankAccount;
    }

    // Getter and Setter for currentAccount
    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    // Getter and Setter for bankAccounts
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    // Getter and Setter for accounts
    public List<Account> getaAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    //methods
    public String toString() {
        return "operator";
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof ServerSideOperator)
            result = currentAccount.equals(((ServerSideOperator) o).currentAccount);
        return result;
    }

    public int hashCode() {
        return currentAccount.hashCode();
    }

    public void startDailyCheck(){
        try {
            dailyChecker = Executors.newSingleThreadExecutor();
            dailyChecker.execute(new DailyCheck());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class DailyCheck implements Runnable{
        public void run() {
            while (true){
                System.out.println("starting daily check");
                int todayDate = Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
                if(todayDate%100==0) {
                    for (BankAccount bankAccount : bankAccounts) {
                        if (bankAccount instanceof GharzOlHasaneJariAccount) {
                            ((GharzOlHasaneJariAccount) bankAccount).checkLoan(todayDate);
                            ((GharzOlHasaneJariAccount) bankAccount).checkCheck(todayDate);
                        } else if (bankAccount instanceof ShortTermInvestmentAccount) {
                            ((ShortTermInvestmentAccount) bankAccount).checkLoan(todayDate);
                        }
                        bankAccount.checkInterest();
                    }
                }else{
                    for (BankAccount bankAccount : bankAccounts) {
                        if (bankAccount instanceof GharzOlHasaneJariAccount) {
                            ((GharzOlHasaneJariAccount) bankAccount).checkLoan(todayDate);
                            ((GharzOlHasaneJariAccount) bankAccount).checkCheck(todayDate);
                        } else if (bankAccount instanceof ShortTermInvestmentAccount) {
                            ((ShortTermInvestmentAccount) bankAccount).checkLoan(todayDate);
                        }
                    }
                }
                try {
                    TimeUnit.DAYS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //
    public String[] accountSignUp(String userName,String password,String rePassword,String name,String dateOfBirst,String id,String phoneNumber) {
        //flags
        boolean userFlag = true;
        boolean passFlag = true;
        boolean rePassFlag = true;
        boolean flagPas1 = true;
        boolean flagPas2 = true;
        boolean flagPas3 = true;
        boolean flagPas4 = true;
        boolean nameFlag = true;
        boolean idFlag = true;
        boolean phoneFlag = true;
        boolean birthFlag = true;
        //variable
        String[] errorList = new String[10];
        for (String s : errorList) {
            s="";
        }
        /*
        0_allError
        1_name&lastNameError
        2_userNameError
        3_passwordError
        4_rePasswordError
        5_idError
        6_phoneNumberError
        7_dateOfBirstError
        */
        //userNameFlag
        if (userName.isEmpty()) {
            userFlag = false;
            errorList[2] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            for (int i = 0; userFlag && i < userName.length(); i++) {
                if ((int) userName.charAt(i) > 122 || ((int) userName.charAt(i) > 90 && (int) userName.charAt(i) < 97) || ((int) userName.charAt(i) > 57 && (int) userName.charAt(i) < 65) || (int) userName.charAt(i) < 48) {
                    userFlag = false;
                    errorList[2] = "یوزرنیم فقط میتواند عدد و حروف انگلیسی باشد";
                    errorList[0] = "error";
                }
            }
        }
        if (userFlag && isUserNameUsed(userName)!=-1) {
            userFlag = false;
            errorList[2] = "نام کاربری تکراری است";
            errorList[0] = "error";
        }
        //passwordFlag
        if (password.isEmpty()) {
            passFlag = false;
            errorList[3] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            for (int i = 0; passFlag && i < password.length(); i++) {
                if ((int) password.charAt(i) > 122 || ((int) password.charAt(i) > 90 && (int) password.charAt(i) < 97) || ((int) password.charAt(i) > 57 && (int) password.charAt(i) < 65) || ((int) password.charAt(i) > 38 && (int) password.charAt(i) < 48) || (int) password.charAt(i) < 33) {
                    passFlag = false;
                    errorList[3] = "رمز فقط میتواند عدد و حروف انگلیسی و حروف خاص باشد";
                    errorList[0] = "error";
                }
            }
        }
        if (passFlag) {
            flagPas1 = !(charCheck(password, 48, 57));
            if (flagPas1) {
                errorList[3] = "رمز عدد ندارد";
                errorList[0] = "error";
            }
            flagPas2 = !(charCheck(password, 97, 122));
            if (flagPas2) {
                errorList[3] = "رمز حرف کوچک انگلیسی ندارد";
                errorList[0] = "error";
            }
            flagPas3 = !(charCheck(password, 65, 90));
            if (flagPas3) {
                errorList[3] = "رمز حرف بزرگ انگلیسی ندارد";
                errorList[0] = "error";
            }
            flagPas4 = !(charCheck(password, 33, 38));
            if (flagPas4) {
                errorList[3] = "رمز کاراکتر خاص ندارد ندارد";
                errorList[0] = "error";
            }
            if (flagPas4 || flagPas3 || flagPas2 || flagPas1) {
                passFlag = false;
            }
        }
        //rePasswordFlag
        if (rePassword.isEmpty()) {
            rePassFlag = false;
            errorList[4] = "فیلد خالی است";
            errorList[0] = "error";
        }
        if (rePassFlag && !(password.equals(rePassword))) {
            rePassFlag = false;
            errorList[4] = "رمز ها یکی نیستن";
            errorList[0] = "error";
        }
        //nameFlag
        if (name.isEmpty()) {
            nameFlag = false;
            errorList[1] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            nameFlag = !((charCheckOut(name, 1740, 1570) && !charCheck(name, 32, 32)));
            if (!nameFlag) {
                errorList[1] = "نام فقط باید حروف فارسی باشد";
                errorList[0] = "error";
            }
        }
        //idFlag
        if (id.isEmpty()) {
            idFlag = false;
            errorList[5] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            idFlag = !(charCheckOut(id, 57, 48));
            if (!idFlag) {
                errorList[5] = "کد ملی فقط باید عدد باشد";
                errorList[0] = "error";
            } else if (id.length() != 10) {
                idFlag = false;
                errorList[5] = "شماره فقط باید 10 رقم باشد";
                errorList[0] = "error";
            }
        }
        //dateOfBirstFlag
        if (dateOfBirst.isEmpty()) {
            birthFlag = false;
            errorList[7] = "فیلد خالی است";
            errorList[0] = "error";
        }else{
            if (dateOfBirst.length() != 10) {
                birthFlag = false;
                errorList[7] = "غیر قابل قبول";
                errorList[0] = "error";
            }else{
                if(charCheckOut(dateOfBirst, 57, 47) || dateOfBirst.charAt(4) != '/' || dateOfBirst.charAt(7) != '/'){
                    birthFlag=false;
                    errorList[7] = "تاریخ تولد فقط باید عدد و / باشد";
                    errorList[0] = "error";
                }
            }
        }
        //phoneNumberFlag
        if(phoneNumber.isEmpty()){
            phoneFlag=false;
            errorList[6] = "فیلد خالی است";
            errorList[0] = "error";
        }else{
            phoneFlag = !(charCheckOut(phoneNumber, 57, 48));
            if (!phoneFlag) {
                errorList[6] = "شماره فقط باید عدد باشد";
                errorList[0] = "error";
            }else{
                if(phoneNumber.length()!=11){
                    phoneFlag=false;
                    errorList[6] = "شماره فقط باید 11 رقم باشد";
                    errorList[0] = "error";
                }
            }
        }
        //
        if (userFlag && passFlag && rePassFlag && nameFlag&& idFlag && phoneFlag && birthFlag) {
            int dateOfBirstInNumber=(dateOfBirst.charAt(0)-48)*1000_00_00+(dateOfBirst.charAt(1)-48)* 100_00_00 +(dateOfBirst.charAt(2)-48)*10_00_00+(dateOfBirst.charAt(3)-48)*1_00_00+(dateOfBirst.charAt(5)-48)*10_00+(dateOfBirst.charAt(6)-48)*1_00+(dateOfBirst.charAt(8)-48)*10+(dateOfBirst.charAt(9)-48);
            currentAccount=new Account(name,userName,password,dateOfBirstInNumber,Long.parseLong(id),Long.parseLong(phoneNumber));
            addAccToAllAccounts(currentAccount);
            //
            Noor.operator.setCurrentAccount(currentAccount);
        }
        return errorList;
    }
    private boolean charCheck(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) >= b && (int) a.charAt(i) <= c)
                an = true;
        }
        return an;
    }
    private boolean charCheckOut(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) > b || (int) a.charAt(i) < c)
                an = true;
        }
        return an;
    }
    private int isUserNameUsed(String userName){
        int index=-1;
        boolean result=false;
        int top=accounts.size()-1;
        int bottom=0;
        int mid=(top+bottom)/2;
        while(!result&&bottom<=top){
            if(accounts.get(mid).getUsername().equals(userName)){
                result=true;
            }else if(accounts.get(mid).getUsername().compareTo(userName)>0){
                top=mid-1;
                mid=(top+bottom)/2;
            }else{
                bottom=mid+1;
                mid=(top+bottom)/2;
            }
        }
        if(result)
            index=mid;
        return index;
    }
    private void addAccToAllAccounts(Account accunt){
        boolean result=false;
        if(accounts.isEmpty()){
            accounts.add(accunt);
        }else {
            if(accunt.getUsername().compareTo(accounts.getFirst().getUsername())<0){
                accounts.addFirst(accunt);
            }else if(accunt.getUsername().compareTo(accounts.getLast().getUsername())>0){
                accounts.add(accunt);
            }else {
                int top = accounts.size() - 1;
                int bottom = 0;
                int mid = (top + bottom) / 2;
                while (!result && bottom <= top) {
                    if (mid + 1 < accounts.size()) {
                        if (accunt.getUsername().compareTo(accounts.get(mid).getUsername()) >= 0 && accunt.getUsername().compareTo(accounts.get(mid + 1).getUsername()) <= 0) {
                            result = true;
                            accounts.add(mid + 1, accunt);
                        } else if (accounts.get(mid).getUsername().compareTo(accunt.getUsername()) > 0) {
                            top = mid - 1;
                            mid = (top + bottom) / 2;
                        } else {
                            bottom = mid + 1;
                            mid = (top + bottom) / 2;
                        }
                    } else {
                        accounts.add(mid, accunt);
                    }
                }
            }
        }
    }
    public String[] checkLogInF(String userName,String password){
        //variable
        String[] errorList = new String[3];
        for (String s : errorList) {
            s="";
        }
        /*
        0_allError
        1_userNameError
        2_passwordError
        */
        //flags
        boolean userNameFlag=true;
        boolean passwordFlag=true;
        if (userName.isEmpty()){
            userNameFlag=false;
            errorList[1]="نام کاربری خود را وارد کنید";
            errorList[0]="error";
        }
        if (password.isEmpty()){
            passwordFlag=false;
            errorList[2]="کد ملی خود را وارد کنید";
            errorList[0]="error";
        }
        if(userNameFlag&&passwordFlag){
            int index = isUserNameUsed(userName);
            if (index==-1){
                errorList[0]="حسابی با این مشخصات وجود ندارد ، از بخش  ثبت نام یکی ایجاد کنید";
            }
            else{
                if(String.valueOf(accounts.get(index).getId()).equals(password)) {
                    currentAccount = accounts.get(index);
                    Noor.operator.setCurrentAccount(currentAccount);
                    errorList[0]="enter";
                }else{
                    errorList[0]="کد ملی اشتباه است";
                }
            }
        }
        return errorList;
    }
    public String[] checkLogIn(String userName,String password){
        //variable
        String[] errorList = new String[3];
        for (String s : errorList) {
            s="";
        }
        /*
        0_allError
        1_userNameError
        2_passwordError
        */
        //flags
        boolean userNameFlag=true;
        boolean passwordFlag=true;
        if (userName.isEmpty()){
            userNameFlag=false;
            errorList[1]="نام کاربری خود را وارد کنید";
            errorList[0]="error";
        }
        if (password.isEmpty()){
            passwordFlag=false;
            errorList[2]="رمز عبور خود را وارد کنید";
            errorList[0]="error";
        }
        if(userNameFlag&&passwordFlag){
            int index = isUserNameUsed(userName);
            if (index==-1){
                errorList[0]="حسابی با این مشخصات وجود ندارد ، از بخش  ثبت نام یکی ایجاد کنید";
            }
            else{
                if(accounts.get(index).getPassword().equals(password)) {
                    currentAccount = accounts.get(index);
                    Noor.operator.setCurrentAccount(currentAccount);
                    errorList[0]="enter";
                }else{
                    errorList[0]="رمز عبور اشتباه است";
                }
            }
        }
        return errorList;
    }
    public void saveAllAccounts(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(".\\systemFiles\\accounts.dat"));
            outputStream.writeObject(accounts);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadAllAccounts(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(".\\systemFiles\\accounts.dat"));
            accounts = (List<Account>) inputStream.readObject();
            inputStream.close();
            //
            accounts.stream().map(o->o.getAccountsList()).forEach(o1-> bankAccounts.addAll(o1));
            //
            accounts.forEach(o->BankAccount.numberOfAccounts+=o.getAccountsList().size());
            Card.numberOfCards= (int) BankAccount.numberOfAccounts;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public String[] editAccount(Account account,String password,String name,String dateOfBirst,String id,String phoneNumber) {
        //flags
        boolean passFlag = true;
        boolean nameFlag = true;
        boolean idFlag = true;
        boolean phoneFlag = true;
        boolean birthFlag = true;
        //variable
        String[] errorList = new String[8];
        for (String s : errorList) {
            s = "";
        }
        /*
        0_allError
        1_nameError
        2_passwordError
        3_idError
        4_phoneNumberError
        5_dateOfBirstError
        */
        //passwordFlag
        if (password.isEmpty()) {
            passFlag = false;
            errorList[2] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //nameFlag
        if (name.isEmpty()) {
            nameFlag = false;
            errorList[1] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            nameFlag = !((charCheckOut(name, 1740, 1570) && !charCheck(name, 32, 32)));
            if (!nameFlag) {
                errorList[1] = "نام فقط باید حروف فارسی باشد";
                errorList[0] = "error";
            }
        }
        //idFlag
        if (id.isEmpty()) {
            idFlag = false;
            errorList[3] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            idFlag = !(charCheckOut(id, 57, 48));
            if (!idFlag) {
                errorList[3] = "کد ملی فقط باید عدد باشد";
                errorList[0] = "error";
            } else if (id.length() != 10) {
                idFlag = false;
                errorList[3] = "شماره فقط باید 10 رقم باشد";
                errorList[0] = "error";
            }
        }
        //dateOfBirstFlag
        if (dateOfBirst.isEmpty()) {
            birthFlag = false;
            errorList[5] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            if (dateOfBirst.length() != 10) {
                birthFlag = false;
                errorList[5] = "غیر قابل قبول";
                errorList[0] = "error";
            } else {
                if (charCheckOut(dateOfBirst, 57, 47) || dateOfBirst.charAt(4) != '/' || dateOfBirst.charAt(7) != '/') {
                    birthFlag = false;
                    errorList[5] = "تاریخ تولد فقط باید عدد و / باشد";
                    errorList[0] = "error";
                }
            }
        }

        //phoneNumberFlag
        if(phoneNumber.isEmpty()){
            phoneFlag=false;
            errorList[4] = "فیلد خالی است";
            errorList[0] = "error";
        }else{
            phoneFlag = !(charCheckOut(phoneNumber, 57, 48));
            if (!phoneFlag) {
                errorList[4] = "شماره فقط باید عدد باشد";
                errorList[0] = "error";
            }else{
                if(phoneNumber.length()!=11){
                    phoneFlag=false;
                    errorList[4] = "شماره فقط باید 11 رقم باشد";
                    errorList[0] = "error";
                }
            }
        }
        //
        if (passFlag && nameFlag && idFlag && phoneFlag && birthFlag) {
            account.setPassword(password);
            account.setNameAndLastName(name);
            account.setId(Long.parseLong(id));
            account.setPhoneNumber(Long.parseLong(phoneNumber));
            int dateOfBirstInNumber=(dateOfBirst.charAt(0)-48)*1000_00_00+(dateOfBirst.charAt(1)-48)* 100_00_00 +(dateOfBirst.charAt(2)-48)*10_00_00+(dateOfBirst.charAt(3)-48)*1_00_00+(dateOfBirst.charAt(5)-48)*10_00+(dateOfBirst.charAt(6)-48)*1_00+(dateOfBirst.charAt(8)-48)*10+(dateOfBirst.charAt(9)-48);
            account.setDateOfBirth(dateOfBirstInNumber);
        }
        return errorList;
    }
}
