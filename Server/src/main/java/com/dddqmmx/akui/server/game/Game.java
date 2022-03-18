package com.dddqmmx.akui.server.game;

import com.dddqmmx.akui.server.Main;
import com.dddqmmx.akui.server.pojo.BackPack;
import com.dddqmmx.akui.server.service.BackPackService;
import com.dddqmmx.akui.server.service.ItemsService;
import com.dddqmmx.akui.server.service.SignInService;
import com.dddqmmx.akui.server.service.UserService;
import com.dddqmmx.akui.server.util.SocketThread;

import java.util.List;

public class Game {

    private SocketThread socketThread;

    public Game(SocketThread socketThread){
        this.socketThread = socketThread;
    }

    public void userInfo(long qq){
        String msg = "货币 : "+ UserService.getMoney(qq) +"\n"+
                     "========物品列表========";
        List<BackPack> backPackList = BackPackService.getBackPack(qq);
        boolean haveItems = false;
        for (BackPack backPack : backPackList) {
            if (!haveItems){
                haveItems = true;
            }
            msg += "\n"+ ItemsService.getName(backPack.getItemId()) +" : "+ backPack.getNumber();
        }
        if (!haveItems){
            msg += "\n无";
        }
        socketThread.send(msg);
    }

    public void signIn(long qq){
        socketThread.send(SignInService.signIn(qq));
    }

}
