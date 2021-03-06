package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.UserDao;
import com.dddqmmx.akui.server.service.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl extends BaseDao implements UserDao {

    @Override
    public int haveUser(long qq) {
        String sql = "select count(qq) from user where qq = ?";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            if (resultSet.next()) {
                return resultSet.getInt("count(qq)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int isAdmin(long qq) {
        String sql = "select count(*) as a from user where qq = ? and isAdmin = true";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            resultSet.next();
            int row = resultSet.getInt("a");
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getProfession(long qq) {
        String sql = "select professionId from user where qq = ?";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            while (resultSet.next()){
                return resultSet.getInt("professionId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String buy(long qq,String name, int number) {
        int itemId = ItemsService.getId(name);
        System.out.println(itemId);
        if (GoodsService.haveGoods(itemId)){
            int money = GoodsService.getNumber(itemId)*number;
            int moneyId = GoodsService.getMoneyId(itemId);
            int userMoney = UserMoneyService.getMoney(qq,moneyId);
            if(money < userMoney){
                UserMoneyService.setMoney(qq,moneyId,userMoney-money);
                BackPackService.setItemNumber(qq,itemId,BackPackService.getItemNumber(qq,itemId)+number);
                return "????????????";
            } else {
                return "??????"+money+ MoneyTypeService.getName(moneyId)+",???????????????"+userMoney+"??????????????????";
            }
        }else {
            return "??????????????????";
        }
    }
}
