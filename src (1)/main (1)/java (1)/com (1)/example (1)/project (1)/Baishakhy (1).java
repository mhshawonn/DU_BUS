package com.example.project;

public class Baishakhy extends BusController {
    public static final String SCHEDULES_FILE_PATH = "src/main/resources/com/example/project/Text files/baishakhy_up_schedules.txt";

    @Override
    public String getSchedulesFilePath() {
        return SCHEDULES_FILE_PATH;
    }
}