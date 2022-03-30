package com.dddqmmx.akui.server.dao;

import java.util.List;
import java.util.Map;

public interface UserMoneyDao {
    int getMoney(long qq,int itemId);
    int setMoney();
    Map<String, String> moneyList(long qq);
}
