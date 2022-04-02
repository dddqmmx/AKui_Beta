package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.UserMoneyDao;
import com.dddqmmx.akui.server.dao.impl.UserMoneyImpl;
import com.dddqmmx.akui.server.pojo.UserMoney;

import java.util.ArrayList;

public class UserMoneyService {
    private static UserMoneyDao userMoneyDao = new UserMoneyImpl();
    public static int getMoney(long qq,int itemId){
        return userMoneyDao.getMoney(qq,itemId);
    }
    public static ArrayList<UserMoney> moneyList(long qq){
        return userMoneyDao.moneyList(qq);
    }
}
