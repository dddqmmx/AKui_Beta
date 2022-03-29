package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.SignInDao;
import com.dddqmmx.akui.server.dao.impl.SignInImpl;
import com.dddqmmx.akui.server.game.Game;
import com.dddqmmx.akui.server.pojo.User;

import java.util.Calendar;
import java.util.Date;

public class SignInService {
    public static SignInDao signInDao = new SignInImpl();

    public static boolean haveSingIn(long qq) {
        return signInDao.haveSingIn(qq) > 0;
    }

    public static Date getSingInTime(long qq){
        return signInDao.getSingInTime(qq);
    }

    public static boolean setSingInTime(long qq,Date time){

        return signInDao.setSingInTime(qq,time) > 0;
    }

    public static String signIn(long qq){
        Date signInTime = signInDao.getSingInTime(qq);
        Date nextSignInTime = null;
        if (null != signInTime){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(signInTime);
            calendar.add(Calendar.DATE,1);
            nextSignInTime = calendar.getTime();
        }
        if (null == nextSignInTime || new Date().compareTo(nextSignInTime) > 0){
            /*setSingInTime(qq,new Date());
            UserService.setMoney(qq,UserService.getMoney(qq)+1);
            return "签到成功,当前货币数量"+ UserService.getMoney(qq)*/;
            return "";
        }else{
            return "你今天已经签到过了,请明天再来";
        }
    }
}
