package com.example.tasklist;

public class Task {
    private String name;
    private String dateStart;
    private String dateEnd;

    public Task(String name, String dateStart, String dateEnd) {
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String getName() {
        return name;
    }

    public String getDateSart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }
}
