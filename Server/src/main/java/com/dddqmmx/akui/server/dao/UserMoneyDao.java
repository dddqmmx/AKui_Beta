package com.dddqmmx.akui.server.dao;

import com.dddqmmx.akui.server.service.pojo.UserMoney;

import java.util.List;

public interface UserMoneyDao {
    int haveMoney(long qq,int moneyId);
    int getMoney(long qq,int moneyId);
    int setMoney(long qq,int moneyId,int number);
    List<UserMoney> moneyList(long qq);
}
