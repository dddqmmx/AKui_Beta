package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.SignInDao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SignInImpl extends BaseDao implements SignInDao {

    @Override
    public Date getSingInTime(long qq) {
        String sql = "select time from sign_in where qq = ?";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            if (resultSet.next()){
                return resultSet.getDate("time");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
