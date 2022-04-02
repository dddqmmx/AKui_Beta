package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.UserMoneyDao;
import com.dddqmmx.akui.server.pojo.UserMoney;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserMoneyImpl extends BaseDao implements UserMoneyDao {

    @Override
    public int getMoney(long qq,int itemId) {
        String sql = "select number from user_money where qq = ? and moneyId = ?";
        Object[] objects = {qq,itemId};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            while (resultSet.next()){
                return resultSet.getInt("number");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int setMoney() {
        return 0;
    }

    @Override
    public ArrayList<UserMoney> moneyList(long qq) {
        String sql = "select moneyId,number from user_money where qq = ?";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        ArrayList<UserMoney> userMoneyList = new ArrayList<>();
        try {
            while (resultSet.next()){
                UserMoney userMoney = new UserMoney();
                userMoney.setMoneyId(resultSet.getInt("moneyId"));
                userMoney.setNumber(resultSet.getInt("number"));
                userMoneyList.add(userMoney);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userMoneyList;
    }

}
