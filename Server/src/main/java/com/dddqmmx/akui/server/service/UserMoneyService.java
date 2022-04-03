package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.UserMoneyDao;
import com.dddqmmx.akui.server.dao.impl.UserMoneyImpl;
import com.dddqmmx.akui.server.pojo.UserMoney;

import java.util.ArrayList;
import java.util.List;

public class UserMoneyService {
    private static UserMoneyDao userMoneyDao = new UserMoneyImpl();
    public static int getMoney(long qq,int moneyId) {
        return userMoneyDao.getMoney(qq, moneyId);
    }
    public static boolean setMoney(long qq,int moneyId,int number){
        return userMoneyDao.setMoney(qq,moneyId,number) > 0;
    }
    public static List<UserMoney> moneyList(long qq){
        return userMoneyDao.moneyList(qq);
    }
}
