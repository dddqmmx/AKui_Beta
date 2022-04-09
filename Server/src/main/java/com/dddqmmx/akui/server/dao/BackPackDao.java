package com.dddqmmx.akui.server.dao;

import com.dddqmmx.akui.server.service.pojo.BackPack;

import java.util.List;

public interface BackPackDao {
    int haveItem(long qq,int itemId);
    int getItemNumber(long qq,int itemId);
    int setItemNumber(long qq,int itemId,int number);
    List<BackPack> getBackPack(long qq);
}
