package com.dddqmmx.akui.server.game;

import com.dddqmmx.akui.server.Main;
import com.dddqmmx.akui.server.service.UserService;
import com.dddqmmx.akui.server.util.SocketThread;

public class Game {

    private SocketThread socketThread;

    public Game(SocketThread socketThread){
        this.socketThread = socketThread;
    }

    public void userInfo(long qq){
        socketThread.send(
            "货币 : "+ UserService.getMoney(qq) +
                  ""
        );
    }

    public void signIn(long qq){

    }

}
