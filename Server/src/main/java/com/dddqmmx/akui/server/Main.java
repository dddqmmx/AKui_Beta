package com.dddqmmx.akui.server;

import com.dddqmmx.akui.server.util.Server;

public class Main {
    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.port = 2077;
            server.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
