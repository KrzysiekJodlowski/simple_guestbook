package com.codecool.model;

import java.util.ArrayList;
import java.util.List;


public class Guestbook {

    List<Entry> listOfEntries;

    public Guestbook() {
        this.listOfEntries = new ArrayList<>();
    }

    public List<Entry> getEntries() {
        return this.listOfEntries;
    }

    public void addEntry(Entry entry) {
        this.listOfEntries.add(entry);
    }

}
