package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.UserMoneyDao;
import com.dddqmmx.akui.server.service.pojo.UserMoney;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMoneyImpl extends BaseDao implements UserMoneyDao {

    @Override
    public int haveMoney(long qq, int moneyId) {
        String sql = "select count(qq) from user_money where qq = ? and moneyId = ?";
        Object[] objects = {qq,moneyId};
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
    public int getMoney(long qq,int moneyId) {
        System.out.println(qq+" "+moneyId);
        String sql = "select number from user_money where qq = ? and moneyId = ?";
        Object[] objects = {qq,moneyId};
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
    public int setMoney(long qq,int moneyId,int number) {
        if (haveMoney(qq,moneyId) > 0){
            String sql = "update user_money set number = ? WHERE qq = ? and  moneyId = ?";
            Object[] objects = {number,qq,moneyId};
            return executeUpdate(sql,objects);
        } else {
            String sql = "insert into user_money values(?,?,?)";
            Object[] objects = {qq,number,moneyId};
            return executeUpdate(sql,objects);
        }
    }

    @Override
    public List<UserMoney> moneyList(long qq) {
        String sql = "select moneyId,number from user_money where qq = ?";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        List<UserMoney> userMoneyList = new ArrayList<>();
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
