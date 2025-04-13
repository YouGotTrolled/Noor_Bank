package com.example.noor_bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ClientSideOperator {
    private List<String> lastPageName;
    private BankAccount currentBankAccount;
    private Account currentAccount;
    private double x;
    private double y;

    static {
        System.out.println("starting");
    }

    //constructor
    public ClientSideOperator(){
        lastPageName=new ArrayList<>();
        lastPageName.add("Main");
        //add the main menu first
    }

    // Getter and Setter for lastPageName
    public List<String> getLastPageName() {
        return lastPageName;
    }

    public void setLastPageName(List<String> lastPageName) {
        this.lastPageName = lastPageName;
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

    //methods
    public String toString() {
        return "operator";
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof ClientSideOperator)
            result = currentAccount.equals(((ClientSideOperator) o).currentAccount);
        return result;
    }

    public int hashCode() {
        return currentAccount.hashCode();
    }

    public void goBack(ActionEvent event){
        if(lastPageName.size()>1){
            try {
                Parent parent = FXMLLoader.load(Noor.class.getResource(lastPageName.get(lastPageName.size()-2)+".fxml"));
                Scene scene = new Scene(parent, 1280, 720);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene.getStylesheets().add(getClass().getResource("fontS.css").toExternalForm());
                stage.setScene(scene);
                makeStageMove(scene,stage);
                stage.show();
                lastPageName.removeLast();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void goTo(String pageName,ActionEvent event){
        goToWithNoFootPrint(pageName,event);
        lastPageName.add(pageName);
    }
    public void goToWithNoFootPrint(String pageName,ActionEvent event){
        try {
            Parent parent = FXMLLoader.load(Noor.class.getResource(pageName+".fxml"));
            Scene scene = new Scene(parent, 1280, 720);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene.getStylesheets().add(getClass().getResource("fontS.css").toExternalForm());
            stage.setScene(scene);
            makeStageMove(scene,stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void makeStageMove(Scene scene, Stage stage){
        scene.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        scene.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
            stage.setOpacity(.6);
        });
        scene.setOnMouseReleased((MouseEvent event) -> stage.setOpacity(1));
    }
    public void closeTheApp(){
        Noor.serverSideOperator.saveAllAccounts();
        System.exit(0);
    }
}
