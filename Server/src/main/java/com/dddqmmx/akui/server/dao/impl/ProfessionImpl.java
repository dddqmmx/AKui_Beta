package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.ProfessionDao;

import java.sql.ResultSet;

public class ProfessionImpl extends BaseDao implements ProfessionDao {

    @Override
    public String getName(int id) {
        String sql = "select name from profession where id = ?";
        Object[] objects = {id};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            while (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
