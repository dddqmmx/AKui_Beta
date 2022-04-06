package com.dddqmmx.akui.server.dao;

public interface UserDao {
    int haveUser(long qq);
    int isAdmin(long qq);
    String buy(long qq,String name,int number);
}
