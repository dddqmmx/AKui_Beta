package com.dddqmmx.akui.server.service;

import com.dddqmmx.akui.server.dao.GoodsDao;
import com.dddqmmx.akui.server.dao.impl.GoodsImpl;
import com.dddqmmx.akui.server.service.pojo.Goods;

import java.util.List;

public class GoodsService {
    private static GoodsDao goodsDao = new GoodsImpl();
    public static List<Goods> goodsList(){
        return goodsDao.goodsList();
    }
}
