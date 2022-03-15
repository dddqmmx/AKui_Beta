package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.SignInDao;
import com.dddqmmx.akui.server.dao.impl.SignInImpl;

import java.util.Date;

public class SignInService {
    public static SignInDao signInDao = new SignInImpl();
    public static String signIn(long qq){
        Date signInTime = signInDao.getSingInTime(qq);
        if (null == signInTime){
            return "可以签到";
        }else{
            return "不能签到";
        }
    }
}
