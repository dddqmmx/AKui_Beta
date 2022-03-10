package com.dddqmmx.akui.server.dao;

import com.dddqmmx.akui.server.pojo.User;

public interface UserDao {
    long getMoney(long qq);
    int isAdmin(long qq);
}
