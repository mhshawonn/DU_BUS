package com.example.project;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

import static javafx.scene.control.cell.TextFieldTableCell.*;

public class DRIVER implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private TextField mobile;

    @FXML
    private TextField name;

    @FXML
    private TableView<Data> table;

    @FXML
    private TableColumn<Data, Integer> textId;

    @FXML
    private TableColumn<Data, String> textMobile;

    @FXML
    private TableColumn<Data, String> textName;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        textName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        textMobile.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        table.setItems(observableList);
        table.setEditable(true);

        textName.setCellFactory(TextFieldTableCell.forTableColumn());
        textMobile.setCellFactory(TextFieldTableCell.forTableColumn());


    }
    ObservableList<Data> observableList= FXCollections.observableArrayList(
            new Data("1","Shawon","01962726587")
    );
    @FXML
    void buttonAdd(ActionEvent event) {
        Data data=new Data(id.getText(),name.getText(),mobile.getText());
        table.getItems().add(data);

    }

    @FXML
    void buttonDelete(ActionEvent event) {
            ObservableList<Data>allData,SingleData;
            allData=table.getItems();
            SingleData=table.getSelectionModel().getSelectedItems();
            SingleData.forEach(allData::remove);

    }

    public void editId(TableColumn.CellEditEvent<Data, Integer> dataIntegerCellEditEvent) {


    }

    public void editName(TableColumn.CellEditEvent<Data, String> dataStringCellEditEvent) {
        Data data=table.getSelectionModel().getSelectedItem();
        data.setName(dataStringCellEditEvent.getNewValue());
    }


    public void editMobile(TableColumn.CellEditEvent<Data, String> dataStringCellEditEvent) {
        Data data=table.getSelectionModel().getSelectedItem();
        data.setPhone(dataStringCellEditEvent.getNewValue());
    }

    public void home(ActionEvent actionEvent) throws IOException {
        Main m=new Main();
        m.changeScene("Admin.fxml");
    }
}
