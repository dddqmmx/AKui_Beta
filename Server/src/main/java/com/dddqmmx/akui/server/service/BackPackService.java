package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.BackPackDao;
import com.dddqmmx.akui.server.dao.impl.BackPackImpl;
import com.dddqmmx.akui.server.service.pojo.BackPack;

import java.util.List;

public class BackPackService {
    private static BackPackDao backPackDao = new BackPackImpl();
    public static List<BackPack> getBackPack(long qq) {
        return backPackDao.getBackPack(qq);
    }
}
