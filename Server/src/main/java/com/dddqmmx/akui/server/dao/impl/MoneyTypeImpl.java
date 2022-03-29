package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.MoneyTypeDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MoneyTypeImpl extends BaseDao implements MoneyTypeDao {
    @Override
    public String getName(int moneyId) {
        String sql = "select name from money_type where id = ?";
        Object[] obj = {moneyId};
        ResultSet resultSet = executeQuery(sql,obj);
        try {
            while (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
