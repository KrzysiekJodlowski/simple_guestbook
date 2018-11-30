package com.codecool;

import com.codecool.controller.GuestbookServer;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;


public class App {

    public static void main(String[] args) {

        try {
            HttpServer server = new GuestbookServer().getServer();
            server.start();
        } catch (IOException ex) {
            ex.printStackTrace(); 
        }

    }
}
