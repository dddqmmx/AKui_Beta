package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.ItemsDao;

import java.sql.ResultSet;

public class ItemsImpl extends BaseDao implements ItemsDao {

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
