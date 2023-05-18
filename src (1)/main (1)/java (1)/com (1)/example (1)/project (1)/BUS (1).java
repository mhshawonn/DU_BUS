package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
public class BUS {
    @FXML
    private Button home;
    @FXML
    private Button exitButton;
    @FXML
    private Label Name;
    @FXML
    private Label Salary;
    @FXML
    private Button isha;
    @FXML
    private Button khonika;
    @FXML
    private Button chaitaly;
    @FXML
    private Button taranga;
    @FXML
    private Button baishakhy;
    @FXML
    private Button ullash;
    @FXML
    private Button srabon;
    @FXML
    private Button basanta;
    @FXML
    private Button kinchit;
    @FXML
    private Button moitri;
    public void Home(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("Admin.fxml");
    }
    public void Isha(ActionEvent actionEvent) throws IOException{
        Main m=new Main();
        m.changeScene("Isha.fxml");
    }
    public void Khonika(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        m.changeScene("Khonika.fxml");
    }
    public void chaitaly(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        m.changeScene("Chaitaly.fxml");
    }
    public void taranga(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        m.changeScene("Taranga.fxml");
    }
    public void baishakhy(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        m.changeScene("Baishakhy.fxml");
    }
    public void ullash(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        m.changeScene("Ullash.fxml");
    }
    public void srabon(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        m.changeScene("Srabon.fxml");
    }
    public void basanta(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        m.changeScene("Basanta.fxml");
    }
    public void kinchit(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        m.changeScene("Kinchit.fxml");
    }
    public void moitri(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        m.changeScene("Moitri.fxml");
    }
    @FXML
    private void handleExitButton(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}