package com.dddqmmx.akui.server.dao;

import com.dddqmmx.akui.server.service.pojo.Goods;

import java.util.List;

public interface GoodsDao {
    int haveGoods(int id);
    List<Goods> goodsList();
}
