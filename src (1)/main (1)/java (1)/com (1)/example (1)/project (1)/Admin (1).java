package com.example.project;

import java.io.IOException;
import java.util.jar.Manifest;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
public class Admin implements Initializable {

    @FXML
    private AnchorPane pane1;
    @FXML
    private AnchorPane pane2;

    @FXML
    private ImageView drawerImage;

    @FXML
    private ImageView exit;
    @FXML
    private Button logout;
    @FXML
    private Button driver;
    @FXML
    private Button bus;
    @FXML
    private ImageView BUS1;
    @FXML
    private ImageView profile;
    @FXML
    private ImageView driverImg;

    



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        pane1.setVisible(false);

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),pane2);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        translateTransition.setByX(-600);
        translateTransition.play();

        drawerImage.setOnMouseClicked(event -> {


            pane1.setVisible(true);

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
//            fadeTransition1.setFromValue(0);
//            fadeTransition1.setToValue(0.15);
            translateTransition1.setByX(+600);
            translateTransition1.play();
        });

        pane1.setOnMouseClicked(event -> {



            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                pane1.setVisible(false);
            });


            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
            translateTransition1.setByX(-600);
            translateTransition1.play();
        });
    }

    public void Logout(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("Login.fxml");
    }

    public void Driver(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("DRIVER.fxml");
    }
    public void Driver1(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("DRIVER.fxml");
    }

    public void Bus(ActionEvent actionEvent) throws IOException{
        Main m= new Main();
        m.changeScene("BUS.fxml");
    }


    public void BUS() throws IOException {
        Main m=new Main();
        m.changeScene("BUS.fxml");
    }



    public void Profile() throws IOException {
        Main m=new Main();
        m.changeScene("profile.fxml");
    }

}
