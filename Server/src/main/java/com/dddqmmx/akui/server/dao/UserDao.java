package com.dddqmmx.akui.server.dao;

public interface UserDao {
    int haveUser(long qq);
    int isAdmin(long qq);
    String buy(String name,int number);
}
