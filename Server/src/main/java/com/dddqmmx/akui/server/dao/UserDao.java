package com.dddqmmx.akui.server.dao;

import com.dddqmmx.akui.server.pojo.User;

public interface UserDao {
    int haveUser(long qq);
    long getMoney(long qq);
    int setMoney(long qq,long money);
    int isAdmin(long qq);
}
