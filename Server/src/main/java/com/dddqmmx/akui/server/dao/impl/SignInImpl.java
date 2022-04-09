package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.SignInDao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SignInImpl extends BaseDao implements SignInDao {

    @Override
    public int haveSingIn(long qq) {
        String sql = "select count(qq) from sign_in where qq = ?";
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
    public Date getSingInTime(long qq) {
        String sql = "select time from sign_in where qq = ?";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            while (resultSet.next()){
                return resultSet.getDate("time");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int setSingInTime(long qq,Date time) {
        System.out.println(time);
        String sql = null;
        Object[] objects = null;
        int haveSingIn =haveSingIn(qq);
        if (haveSingIn > 0) {
            System.out.println("update");
            sql = "update sign_in set time = ? where qq = ?";
            objects = new Object[]{time,qq};
        } else {
            sql = "insert into sign_in values (?,?)";
            objects = new Object[]{qq,time};
        }
        return executeUpdate(sql,objects);
    }
}
