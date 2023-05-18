package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class Main extends Application {
    double x=0,y=0;
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;
        stage.setResizable(false);
        Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene=new Scene(root,600,400);
        stage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.setTitle("DU BUS");
        scene.getStylesheets().add("file:src/main/resources/com/example/project/style.css");
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(String fxml) throws IOException{
            Parent pane =FXMLLoader.load(getClass().getResource(fxml));
            stg.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        launch();
    }
}