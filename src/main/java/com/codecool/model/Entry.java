package com.codecool.model;

import java.sql.Date;


public class Entry {

    private String content;
    private String name;
    private Date date;

    public Entry(String content, String name, Date date) {
        this.content = content;
        this.name = name;
        this.date = date;
    }

}
