package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.UserDao;
import com.dddqmmx.akui.server.service.GoodsService;
import com.dddqmmx.akui.server.service.ItemsService;
import com.dddqmmx.akui.server.service.MoneyTypeService;
import com.dddqmmx.akui.server.service.UserMoneyService;

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
    public String buy(long qq,String name, int number) {
        int itemId = ItemsService.getId(name);
        if (GoodsService.haveGoods(itemId)){
            int money = GoodsService.getNumber(itemId)*number;
            int moneyId = GoodsService.getMoneyId(itemId);
            int userMoney = UserMoneyService.getMoney(qq,moneyId);
            if(money < userMoney){
                UserMoneyService.setMoney(qq,moneyId,userMoney-money);
                return "购买成功";
            } else {
                return "需要"+money+ MoneyTypeService.getName(moneyId)+",用户现在有"+userMoney+"个。不能购买";
            }
        }else {
            return "没有这种商品";
        }
    }
}
