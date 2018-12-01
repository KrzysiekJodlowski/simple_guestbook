package com.codecool.view;

import com.codecool.model.Entry;
import com.sun.net.httpserver.HttpExchange;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class EntriesView {
    HttpExchange httpExchange;
    JtwigTemplate template ;
    JtwigModel model;

    public EntriesView(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
        this.template = JtwigTemplate.classpathTemplate("templates/guestbook.twig");
        this.model = JtwigModel.newModel();
    }

    public void showEntries(List<Entry> listOfEntries) throws IOException {
        model.with("entries", listOfEntries);

        String response = template.render(model);

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
