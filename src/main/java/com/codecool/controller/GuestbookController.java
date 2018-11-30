package com.codecool.controller;

import com.codecool.dao.GuestbookDAOimpl;
import com.codecool.model.Entry;
import com.codecool.model.Guestbook;
import com.codecool.view.EntriesView;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GuestbookController implements HttpHandler {
    private GuestbookDAOimpl guestbookDAO;
    private Guestbook guestbook;
    private List<Entry> listOfEntries;
    private EntriesView entriesView;

    public GuestbookController() {
        this.guestbookDAO = new GuestbookDAOimpl();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        this.entriesView = new EntriesView(httpExchange);
        String method = httpExchange.getRequestMethod();

        if(method.equals("GET")){

            guestbook = guestbookDAO.loadGuestbook();
            listOfEntries = guestbook.getEntries();
            entriesView.showEntries(listOfEntries);
        }

        if(method.equals("POST")){

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();

            Map inputs = parseFormData(formData);
            String message = (String) inputs.get("message");
            String name = (String) inputs.get("name");

            Entry newEntry = createNewEntry(message, name);
            addNewEntryToList(newEntry);
            addNewEntryToDatabase(newEntry);

            guestbook = guestbookDAO.loadGuestbook();
            listOfEntries = guestbook.getEntries();
            entriesView.showEntries(listOfEntries);
        }
    }

    private static Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String[] pairs = formData.split("&");
        for(String pair : pairs){
            String[] keyValue = pair.split("=");
            String value = new URLDecoder().decode(keyValue[1], "UTF-8");
            map.put(keyValue[0], value);
        }
        return map;
    }

    private Entry createNewEntry(String content, String name) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return new Entry(content, name, currentDateTime);
    }

    private void addNewEntryToList(Entry newEntry) {
        listOfEntries.add(newEntry);
    }

    private void addNewEntryToDatabase(Entry newEntry) {
        guestbookDAO.addEntry(newEntry);
    }

}
