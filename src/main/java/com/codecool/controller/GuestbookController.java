package com.codecool.controller;

import com.codecool.dao.GuestbookDAOimpl;
import com.codecool.model.Entry;
import com.codecool.model.Guestbook;
import com.codecool.view.EntriesView;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GuestbookController implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String response = "odpowiedz";
        String method = httpExchange.getRequestMethod();

        if(method.equals("GET")){

            Guestbook guestbook = new GuestbookDAOimpl().loadGuestbook();
            List<Entry> listOfEntries = guestbook.getEntries();

            new EntriesView(httpExchange).showEntries(listOfEntries);
        }

        if(method.equals("POST")){

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();

            Map inputs = parseFormData(formData);

            System.out.println(inputs.get("message") + " " + inputs.get("name"));

            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
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

}
