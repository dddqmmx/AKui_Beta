package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.GoodsDao;
import com.dddqmmx.akui.server.service.pojo.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsImpl extends BaseDao implements GoodsDao {
    @Override
    public int haveGoods(int id) {
        String sql = "select count(*) as sum from goods where itemId = ?";
        Object[] objects = {id};
        ResultSet resultSet = executeQuery(sql,objects);
        try {

        }catch (SQLException e){

        }
        return 0;
    }

    @Override
    public List<Goods> goodsList() {
        List<Goods> goodsList = new ArrayList<>();
        String sql = "select * from goods";
        Object[] objects = {};
        ResultSet resultSet = executeQuery(sql,objects);
        try {
            while (resultSet.next()){
                Goods goods = new Goods();
                goods.setItemId(resultSet.getInt("itemId"));
                goods.setMoney(resultSet.getInt("moneyId"));
                goods.setNumber(resultSet.getInt("number"));
                goodsList.add(goods);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return goodsList;
    }
}
