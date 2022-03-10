package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.UserDao;
import com.dddqmmx.akui.server.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl extends BaseDao implements UserDao {
    @Override
    public long getMoney(long qq) {
        String sql = "select money from user where qq = ?";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            resultSet.next();
            return resultSet.getLong("money");
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
}
