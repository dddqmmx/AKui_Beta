package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.UserDao;
import com.dddqmmx.akui.server.dao.impl.UserImpl;

public class UserService {
    private static UserDao userDao = new UserImpl();
    public static boolean haveUser(long qq){
        return userDao.haveUser(qq) > 0;
    }
    public static int getProfession(long qq){return userDao.getProfession(qq);}
    public static boolean isAdmin(long qq){
        return userDao.isAdmin(qq) > 0;
    }
    public static String buy(long qq,String name,int number) {
        return userDao.buy(qq,name,number);
    };
}
