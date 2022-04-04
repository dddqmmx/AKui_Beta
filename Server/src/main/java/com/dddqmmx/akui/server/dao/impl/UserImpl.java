package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.UserDao;
import com.dddqmmx.akui.server.service.GoodsService;
import com.dddqmmx.akui.server.service.ItemsService;

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
    public String buy(String name, int number) {
        int itemId = ItemsService.getId(name);
        if (GoodsService.haveGoods(itemId)){
            return "ok";
        }else {
            return "没有这种商品";
        }
    }
}
