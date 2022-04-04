package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.ItemsDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemsImpl extends BaseDao implements ItemsDao {

    @Override
    public int getId(String name) {
        String sql = "select id from items where name = ?";
        Object[] objects = {name};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            while (resultSet.next()){
                return resultSet.getInt("id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getName(int itemId) {
        String sql = "select name from items where id = ?";
        Object[] objects = {itemId};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            resultSet.next();
            return resultSet.getString("name");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
