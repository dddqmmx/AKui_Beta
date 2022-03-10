package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.UserDao;
import com.dddqmmx.akui.server.dao.impl.UserImpl;

public class UserService {
    private static UserDao userDao = new UserImpl();
    public static long getMoney(long qq){
        return userDao.getMoney(qq);
    }
    public static boolean isAdmin(long qq){
        return userDao.isAdmin(qq) > 0;
    }
}