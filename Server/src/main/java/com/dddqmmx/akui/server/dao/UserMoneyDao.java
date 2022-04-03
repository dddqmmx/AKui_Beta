package com.dddqmmx.akui.server.dao;

import com.dddqmmx.akui.server.pojo.UserMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserMoneyDao {
    int haveMoney(long qq,int moneyId);
    int getMoney(long qq,int moneyId);
    int setMoney(long qq,int moneyId,int number);
    List<UserMoney> moneyList(long qq);
}
