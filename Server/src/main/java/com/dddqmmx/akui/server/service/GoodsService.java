package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.GoodsDao;
import com.dddqmmx.akui.server.dao.impl.GoodsImpl;
import com.dddqmmx.akui.server.service.pojo.Goods;

import java.util.List;

public class GoodsService {
    private static GoodsDao goodsDao = new GoodsImpl();
    public static boolean haveGoods(int id) {
        return goodsDao.haveGoods(id) > 0;
    }
    public static int getMoneyId(int id){
        return goodsDao.getMoneyId(id);
    }
    public static int getNumber(int id){
        return goodsDao.getNumber(id);
    }
    public static List<Goods> goodsList(){
        return goodsDao.goodsList();
    }
}
