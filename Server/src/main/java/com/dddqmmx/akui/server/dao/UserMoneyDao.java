package com.dddqmmx.akui.server.dao;

import com.dddqmmx.akui.server.pojo.UserMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserMoneyDao {
    int getMoney(long qq,int itemId);
    int setMoney();
    List<UserMoney> moneyList(long qq);
}
