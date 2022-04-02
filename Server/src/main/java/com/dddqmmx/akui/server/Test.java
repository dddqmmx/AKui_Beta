package com.dddqmmx.akui.server;

import com.dddqmmx.akui.server.pojo.BackPack;
import com.dddqmmx.akui.server.pojo.UserMoney;
import com.dddqmmx.akui.server.service.BackPackService;
import com.dddqmmx.akui.server.service.MoneyTypeService;
import com.dddqmmx.akui.server.service.UserMoneyService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<UserMoney> moneyList = UserMoneyService.moneyList(1538080366L);
        for (UserMoney userMoney : moneyList){
            System.out.println(userMoney.getMoneyId()+" = "+ userMoney.getNumber());
        }
    }
}
