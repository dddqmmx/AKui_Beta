package com.dddqmmx.akui.server.dao;

import com.dddqmmx.akui.server.pojo.User;

public interface UserDao {
    int haveUser(long qq);
    int isAdmin(long qq);
}
