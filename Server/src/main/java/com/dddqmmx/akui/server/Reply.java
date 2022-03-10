package com.dddqmmx.akui.server;

import com.dddqmmx.akui.server.service.UserService;
import com.dddqmmx.akui.server.util.SocketThread;
import org.json.JSONObject;

public class Reply {
    public void socket(String msg, SocketThread socketThread){
        System.out.println(msg);
        JSONObject json = new JSONObject(msg);
        String command = json.getString("command");
        long qq = json.getLong("qq");

        switch (command){
            case "getMoney":
                socketThread.send(String.valueOf(UserService.getMoney(qq)));
                break;
            case "isAdmin":
                socketThread.send(String.valueOf(UserService.isAdmin(qq)));
        }
    }
}
