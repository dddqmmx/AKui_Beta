package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BackPackDao;
import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.service.pojo.BackPack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BackPackImpl extends BaseDao implements BackPackDao {


    @Override
    public int haveItem(long qq, int itemId) {
        String sql = "select count(*) as sum from back_pack where qq = ? and itemId = ?";
        Object[] objects = {qq,itemId};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            while (resultSet.next()){
                return resultSet.getInt("sum");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getItemNumber(long qq, int itemId) {
        String sql = "select number from back_pack where qq = ? and itemId = ?";
        Object[] objects = {qq,itemId};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            while (resultSet.next()) {
                return resultSet.getInt("number");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int setItemNumber(long qq, int itemId, int number) {
        if (haveItem(qq, itemId) > 0) {
            String sql = "update back_pack set number = ? where qq = ? and itemId = ?";
            Object[] objects = {number, qq, itemId};
            return executeUpdate(sql,objects);
        }else {
            String sql = "insert into back_pack values (?,?,?)";
            Object[] objects = {qq, itemId, number};
            return executeUpdate(sql,objects);
        }
    }

    @Override
    public List<BackPack> getBackPack(long qq) {
        String sql = "select itemId,number from back_pack where qq = ?";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        List<BackPack> backPackList = new ArrayList<>();
        try {
            while (resultSet.next()){
                BackPack backPack = new BackPack();
                backPack.setItemId(resultSet.getInt("itemId"));
                backPack.setNumber(resultSet.getInt("number"));
                backPackList.add(backPack);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return backPackList;
    }
}
