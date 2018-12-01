package com.codecool.controller;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;


public class GuestbookServer {
    HttpServer server;

    public GuestbookServer() throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(8000), 0);
        setRoutes(server);
    }

    private void setRoutes(HttpServer server) {
        server.createContext("/guestbook", new GuestbookController());
        server.setExecutor(null);
    }

    public HttpServer getServer() {
        return this.server;
    }

}
