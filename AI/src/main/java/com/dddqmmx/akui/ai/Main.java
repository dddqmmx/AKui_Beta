package com.dddqmmx.akui.ai;

import com.dddqmmx.akui.ai.thread.Console;
import com.dddqmmx.akui.ai.thread.Server;

public class Main {

    public static Server server = null;

    public static void main(String[] args) {

        Console console = new Console();
        console.start();

        server = new Server();
        server.start();

        Control.newAI();
        Control.startAI();
    }
}
