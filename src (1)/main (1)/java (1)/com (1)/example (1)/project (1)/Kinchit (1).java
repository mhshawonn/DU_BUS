package com.example.project;

public class Kinchit extends BusController {
    public static final String SCHEDULES_FILE_PATH = "src\\main\\resources\\com\\example\\project\\Text files\\kinchit_up_schedules.txt";

    @Override
    public String getSchedulesFilePath() {
        return SCHEDULES_FILE_PATH;
    }
}