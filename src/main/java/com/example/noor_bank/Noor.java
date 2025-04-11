package com.example.noor_bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Noor extends Application {
    public static ClientSideOperator operator;
    private double x;
    private double y;

    @Override
    public void start(Stage stage) throws IOException {
        operator = new ClientSideOperator();
        FXMLLoader fxmlLoader = new FXMLLoader(Noor.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Image ic = new Image("Noor.png");
        stage.setMinHeight(720);
        stage.setMinWidth(1280);
        stage.getIcons().add(ic);
        stage.setTitle("Noor Bank");
        stage.setResizable(false);
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
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("fontS.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}