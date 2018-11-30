package com.codecool.model;

import java.time.LocalDateTime;


public class Entry {

    private String content;
    private String name;
    private LocalDateTime date;

    public Entry(String content, String name, LocalDateTime date) {
        this.content = content;
        this.name = name;
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date.getDayOfMonth() + "." + this.date.getMonthValue() + "." + this.date.getYear() + " " +
                this.date.getHour() + ":" + this.date.getMinute() + ":" + this.date.getSecond();
    }

}
