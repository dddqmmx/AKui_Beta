package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.BackPackDao;
import com.dddqmmx.akui.server.dao.impl.BackPackImpl;
import com.dddqmmx.akui.server.service.pojo.BackPack;

import java.util.List;

public class BackPackService {
    private static BackPackDao backPackDao = new BackPackImpl();
    public static int getItemNumber(long qq, int itemId){
        return backPackDao.getItemNumber(qq,itemId);
    }
    public static boolean setItemNumber(long qq, int itemId, int number){
        System.out.println(itemId + " " + number);
        return backPackDao.setItemNumber(qq, itemId, number) > 0;
    }
    public static List<BackPack> getBackPack(long qq) {
        return backPackDao.getBackPack(qq);
    }
}
