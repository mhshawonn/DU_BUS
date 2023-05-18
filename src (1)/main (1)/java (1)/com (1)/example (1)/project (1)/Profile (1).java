package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.*;


import java.io.IOException;


public class Profile {
    @FXML
    private Button home;
    @FXML
    private Button edit;
    @FXML
    private AnchorPane root;
    @FXML
    private Button show;
    @FXML
    private Label labell;
    @FXML
    private Label clickon;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField ageTextField;

    private static final String DATA_DIRECTORY = "E:/";
    private static final String USER_PROFILE_FILE = "/Hello/userprofile/src/main/java/com/example/userprofile/userProfile.ser";


    @FXML
    public void loadUserProfile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_DIRECTORY + USER_PROFILE_FILE))) {
            UserProfile user = (UserProfile) inputStream.readObject();
            nameTextField.setText(user.getName());
            emailTextField.setText(user.getEmail());
            ageTextField.setText(Integer.toString(user.getAge()));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void home() throws IOException {
        Main m=new Main();
        m.changeScene("Admin.fxml");
    }
    public void Edit() throws IOException{
        Main m=new Main();
        m.changeScene("Loadprofile.fxml");
    }

}
