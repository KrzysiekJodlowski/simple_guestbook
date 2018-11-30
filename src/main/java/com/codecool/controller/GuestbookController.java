package com.codecool.controller;

import com.codecool.dao.GuestbookDAOimpl;
import com.codecool.model.Entry;
import com.codecool.model.Guestbook;
import com.codecool.view.EntriesView;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.util.List;


public class GuestbookController implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        Guestbook guestbook = new GuestbookDAOimpl().loadGuestbook();
        List<Entry> listOfEntries = guestbook.getEntries();

        new EntriesView(httpExchange).showEntries(listOfEntries);
    }

}
