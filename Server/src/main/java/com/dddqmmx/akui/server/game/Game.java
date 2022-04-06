package com.dddqmmx.akui.server.game;

import com.dddqmmx.akui.server.dao.impl.UserImpl;
import com.dddqmmx.akui.server.service.pojo.BackPack;
import com.dddqmmx.akui.server.service.pojo.Goods;
import com.dddqmmx.akui.server.service.pojo.UserMoney;
import com.dddqmmx.akui.server.service.*;
import com.dddqmmx.akui.server.util.SocketThread;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private SocketThread socketThread;

    public Game(SocketThread socketThread){
        this.socketThread = socketThread;
    }

    public void userInfo(long qq){
        String msg = "";
        List<UserMoney> userMoneyList = UserMoneyService.moneyList(qq);
        boolean haveMoney = false;
        for (UserMoney userMoney : userMoneyList){
            if (!haveMoney){
                haveMoney = true;
            }
            msg += "\n" + MoneyTypeService.getName(userMoney.getMoneyId()) +" : "+ userMoney.getNumber();
        }
        if (!haveMoney){
            msg += "\n无";
        }
        msg += "\n========物品列表========";
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

    public void systemStore(){
        String msg = "";
        List<Goods> goodsList = GoodsService.goodsList();
        for (Goods goods : goodsList){
            msg += "\n"+ItemsService.getName(goods.getItemId()) + " " + goods.getNumber()+MoneyTypeService.getName(goods.getMoney());
        }
        socketThread.send(msg);
    }

    public void buy(long qq,String name,int number){
        socketThread.send(UserService.buy(qq,name,number));
    }
}
