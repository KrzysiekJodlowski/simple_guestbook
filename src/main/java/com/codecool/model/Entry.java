package com.codecool.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return this.date.format(formatter);
    }

}
