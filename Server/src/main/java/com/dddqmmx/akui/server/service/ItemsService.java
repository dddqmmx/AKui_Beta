package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.ItemsDao;
import com.dddqmmx.akui.server.dao.impl.ItemsImpl;

public class ItemsService {
    private static ItemsDao itemsDao = new ItemsImpl();
    public static String getName(int itemId){
        return itemsDao.getName(itemId);
    }
}
