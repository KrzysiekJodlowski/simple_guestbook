package com.codecool.model;

import java.text.DateFormat;


public class Entry {

    private String content;
    private String name;
    private DateFormat date;

    public Entry(String content, String name, DateFormat date) {
        this.content = content;
        this.name = name;
        this.date = date;
    }

}
