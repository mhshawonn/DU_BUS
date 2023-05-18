package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.animation.*;
import javafx.util.Duration;

import java.io.*;

import java.io.IOException;

public class LoadProfile {
    @FXML
    private Button back;
    @FXML
    private AnchorPane root;
    @FXML
    private Button load;


    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField ageTextField;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;

    private static final String DATA_DIRECTORY = "E:/";
    private static final String USER_PROFILE_FILE = "/Hello/userprofile/src/main/java/com/example/userprofile/userProfile.ser";

    @FXML
    public void saveUserProfile() {
        UserProfile user = new UserProfile(nameTextField.getText(), emailTextField.getText(), Integer.parseInt(ageTextField.getText()));
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_DIRECTORY + USER_PROFILE_FILE))) {
            outputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void animateLabel() {
        Timeline timeline = new Timeline();

        KeyValue kv1 = new KeyValue(label1.opacityProperty(), 0);
        KeyValue kv2 = new KeyValue(label1.opacityProperty(), 1);

        KeyFrame kf1 = new KeyFrame(Duration.millis(0), kv1);
        KeyFrame kf2 = new KeyFrame(Duration.millis(500), kv2);

        timeline.getKeyFrames().addAll(kf1, kf2);
        timeline.play();
    }
    public void animateLabel3() {
        Timeline timeline = new Timeline();

        KeyValue kv1 = new KeyValue(label3.opacityProperty(), 0);
        KeyValue kv2 = new KeyValue(label3.opacityProperty(), 1);

        KeyFrame kf1 = new KeyFrame(Duration.millis(0), kv1);
        KeyFrame kf2 = new KeyFrame(Duration.millis(500), kv2);

        timeline.getKeyFrames().addAll(kf1, kf2);
        timeline.play();
    }
    public void prev() throws IOException {
        Main m=new Main();
        m.changeScene("profile.fxml");
    }
}
