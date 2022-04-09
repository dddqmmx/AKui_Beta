package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.ProfessionDao;
import com.dddqmmx.akui.server.dao.impl.ProfessionImpl;

public class ProfessionService {
    private static final ProfessionDao professionDao = new ProfessionImpl();
    public static String getName(int id){
        return professionDao.getName(id);
    }
}
