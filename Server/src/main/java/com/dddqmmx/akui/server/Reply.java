package com.dddqmmx.akui.server;

import com.dddqmmx.akui.server.game.Game;
import com.dddqmmx.akui.server.service.UserService;
import com.dddqmmx.akui.server.util.SocketThread;
import org.json.JSONObject;

public class Reply {
    public void socket(String msg, SocketThread socketThread){
        System.out.println(msg);
        JSONObject json = new JSONObject(msg);
        String command = json.getString("command");
        long qq = 0;
        if (!json.isNull("qq")){
            qq = json.getLong("qq");
        }
        Game game = new Game(socketThread);
        switch (command){
            case "userInfo":
                game.userInfo(qq);
                break;
            case "isAdmin":
                socketThread.send(String.valueOf(UserService.isAdmin(qq)));
                break;
            case "signIn":
                game.signIn(qq);
                break;
            case "systemStore":
                game.systemStore();
                break;
        }
    }
}
