package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BackPackDao;
import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.pojo.BackPack;
import com.dddqmmx.akui.server.pojo.Items;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BackPackImpl extends BaseDao implements BackPackDao {
    @Override
    public List<BackPack> getBackPack(long qq) {
        String sql = "select (select name from items where id = itemId) as name,number from back_pack where qq = ?";
        Object[] objects = {qq};
        ResultSet resultSet = executeQuery(sql,objects);
        List<BackPack> backPackList = new ArrayList<>();
        try {
            while (resultSet.next()){
                BackPack backPack = new BackPack();
                Items items = new Items();
                items.setName(resultSet.getString("name"));
                backPack.setItems(items);
                backPack.setNumber(resultSet.getInt("number"));
                backPackList.add(backPack);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return backPackList;
    }
}
