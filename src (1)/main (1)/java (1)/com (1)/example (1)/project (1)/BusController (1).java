package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.event.EventHandler;
import javafx.stage.Stage;



class BusSchedule {
    private String busId;
    private String upSchedule;
    private String downSchedule;
    private String startingPosition;
    private String endingPosition;

    public BusSchedule(String busId, String upSchedule, String downSchedule, String startingPosition, String endingPosition) {
        this.busId = busId;
        this.upSchedule = upSchedule;
        this.downSchedule = downSchedule;
        this.startingPosition = startingPosition;
        this.endingPosition = endingPosition;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getUpSchedule() {
        return upSchedule;
    }

    public void setUpSchedule(String upSchedule) {
        this.upSchedule = upSchedule;
    }

    public String getDownSchedule() {
        return downSchedule;
    }

    public void setDownSchedule(String downSchedule) {
        this.downSchedule = downSchedule;
    }
    public void setStartingPosition(String startingPosition){
        this.startingPosition = startingPosition;
    }
    public String getStartingPosition(){
        return startingPosition;
    }
    public void setEndingPosition(String endingPosition){
        this.endingPosition = endingPosition;
    }
    public String getEndingPosition(){
        return endingPosition;
    }
}

public class BusController {

    @FXML
    public TableView<BusSchedule> busScheduleTable;
    @FXML
    private TableColumn<BusSchedule, String> busIdColumn;
    @FXML
    private TableColumn<BusSchedule, String> upScheduleColumn;
    @FXML
    private TableColumn<BusSchedule, String> downScheduleColumn;
    @FXML
    private TableColumn<BusSchedule, String> startingPositionColumn;
    @FXML
    private TableColumn<BusSchedule, String> endingPositionColumn;
    @FXML
    private Button addScheduleButton;
    @FXML
    private Button deleteScheduleButton;
    @FXML
    private Button back;
    @FXML
    private Button exitButton;
    @FXML
    private TextField busIdField;
    @FXML
    private TextField upScheduleField;
    @FXML
    private TextField downScheduleField;
    @FXML
    private TextField startingPosField;
    @FXML
    private TextField endingPosField;

    private final List<BusSchedule> schedules = new ArrayList<>();

    @FXML
    public void initialize() {
        addScheduleButton.setOnAction(this::handleAddScheduleButton);
        deleteScheduleButton.setOnAction(this::handleDeleteScheduleButton);
        //downAddButton.setOnAction(event -> addSchedule(downScheduleField, downScheduleList, downFile));
        // Load the schedules from the file
        loadSchedulesFromFile();

// Set up the table columns to display the data and allow editing
        busIdColumn.setEditable(true);
        busIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBusId()));
        busIdColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        }));

        busIdColumn.setOnEditCommit((TableColumn.CellEditEvent<BusSchedule, String> t) -> {
            t.getTableView().getItems().get(
                    t.getTablePosition().getRow()).setBusId(t.getNewValue());
            saveDataToFile();
        });

// Set up the upScheduleColumn to display the data and allow editing
        upScheduleColumn.setEditable(true);
        upScheduleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUpSchedule()));
        upScheduleColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        }));

        upScheduleColumn.setOnEditCommit((TableColumn.CellEditEvent<BusSchedule, String> t) -> {
            t.getTableView().getItems().get(
                    t.getTablePosition().getRow()).setUpSchedule(t.getNewValue());
            saveDataToFile();
        });

// Set up the downScheduleColumn to display the data and allow editing
        downScheduleColumn.setEditable(true);
        downScheduleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDownSchedule()));
        downScheduleColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        }));

        downScheduleColumn.setOnEditCommit((TableColumn.CellEditEvent<BusSchedule, String> t) -> {
            t.getTableView().getItems().get(
                    t.getTablePosition().getRow()).setDownSchedule(t.getNewValue());
            saveDataToFile();
        });

        startingPositionColumn.setEditable(true);
        startingPositionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartingPosition()));
        startingPositionColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        }));

        startingPositionColumn.setOnEditCommit((TableColumn.CellEditEvent<BusSchedule, String> t) -> {
            t.getTableView().getItems().get(
                    t.getTablePosition().getRow()).setStartingPosition(t.getNewValue());
            saveDataToFile();
        });

        endingPositionColumn.setEditable(true);
        endingPositionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndingPosition()));
        endingPositionColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        }));

        endingPositionColumn.setOnEditCommit((TableColumn.CellEditEvent<BusSchedule, String> t) -> {
            t.getTableView().getItems().get(
                    t.getTablePosition().getRow()).setEndingPosition(t.getNewValue());
            saveDataToFile();
        });

    }
    public static String SCHEDULES_FILE_PATH;
    public String getSchedulesFilePath() {
        return SCHEDULES_FILE_PATH;
    }
    void loadSchedulesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getSchedulesFilePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    BusSchedule schedule = new BusSchedule(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    schedules.add(schedule);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Ignore errors, just start with an empty list
        }

        // Create an ObservableList from the schedules list and bind it to the TableView
        ObservableList<BusSchedule> observableSchedules = FXCollections.observableArrayList(schedules);
        busScheduleTable.setItems(observableSchedules);
        busScheduleTable.setEditable(true);

    }

    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getSchedulesFilePath()))) {
            for (BusSchedule schedule : schedules) {
                writer.write(schedule.getBusId() + "," + schedule.getUpSchedule() + "," + schedule.getDownSchedule() + "," + schedule.getStartingPosition() + "," + schedule.getEndingPosition());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }
    }

    @FXML
    private void handleAddScheduleButton(ActionEvent event) {
        // Get the values from the text fields
        String busId = busIdField.getText();
        String upSchedule = upScheduleField.getText();
        String downSchedule = downScheduleField.getText();
        String startingPosition = startingPosField.getText();
        String endingPosition = endingPosField.getText();

        // Create a new schedule and add it to the list
        BusSchedule newSchedule = new BusSchedule(busId, upSchedule, downSchedule, startingPosition, endingPosition);
        schedules.add(newSchedule);

        // Clear the text fields
        busIdField.clear();
        upScheduleField.clear();
        downScheduleField.clear();
        startingPosField.clear();
        endingPosField.clear();

        // Refresh the table to show the new schedule
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getSchedulesFilePath()))) {
            for (BusSchedule schedule : schedules) {
                writer.write(schedule.getBusId() + "," + schedule.getUpSchedule() + "," + schedule.getDownSchedule() + "," + schedule.getStartingPosition() + "," + schedule.getEndingPosition());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }
        busScheduleTable.setItems(FXCollections.observableArrayList(schedules));
    }
    @FXML
    private void handleDeleteScheduleButton(ActionEvent event) {
        // Find the selected row
        int selectedIndex = busScheduleTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            // Remove the selected schedule from the list
            BusSchedule selectedSchedule = schedules.remove(selectedIndex);

            // Clear the text fields
            busIdField.clear();
            upScheduleField.clear();
            downScheduleField.clear();
            startingPosField.clear();
            endingPosField.clear();

            // Remove the selected schedule from the file
            try {
                Path path = Paths.get(getSchedulesFilePath());
                List<String> lines = Files.readAllLines(path);
                lines.remove(selectedIndex);
                Files.write(path, lines);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the error appropriately
            }

            // Refresh the table to show the updated list
            busScheduleTable.setItems(FXCollections.observableArrayList(schedules));
        }
    }

    public void busIdEdit(TableColumn.CellEditEvent<BusSchedule, String> busScheduleStringCellEditEvent) {
        // Get the new value from the edited cell
        String newValue = busScheduleStringCellEditEvent.getNewValue();

        // Get the selected row and update its property
        BusSchedule selectedSchedule = busScheduleStringCellEditEvent.getRowValue();
        selectedSchedule.setUpSchedule(newValue);

        // Update the table with the new data
        busScheduleTable.refresh();
    }

    public void backButton(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("BUS.fxml");
    }

    @FXML
    private void handleExitButton(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}