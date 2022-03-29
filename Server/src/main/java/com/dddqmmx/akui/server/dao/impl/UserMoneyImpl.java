package com.dddqmmx.akui.server.dao.impl;

import com.dddqmmx.akui.server.dao.BaseDao;
import com.dddqmmx.akui.server.dao.UserMoneyDao;

public class UserMoneyImpl extends BaseDao implements UserMoneyDao {

    @Override
    public String getMoney(long qq,int itemId) {
        String sql = "select number from user_money where qq = ? and moneyId = ?";
        Object[] obj = {qq,itemId};

        return null;
    }

    @Override
    public int setMoney() {
        return 0;
    }
}
