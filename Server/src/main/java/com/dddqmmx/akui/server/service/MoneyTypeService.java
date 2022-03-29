package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.MoneyTypeDao;
import com.dddqmmx.akui.server.dao.impl.MoneyTypeImpl;

public class MoneyTypeService {
    private static final MoneyTypeDao moneyTypeDao = new MoneyTypeImpl();
    public static String getName(int moneyId){
        return moneyTypeDao.getName(moneyId);
    }
}
