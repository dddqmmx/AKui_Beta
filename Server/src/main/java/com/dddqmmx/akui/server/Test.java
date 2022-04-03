package com.dddqmmx.akui.server;

import com.dddqmmx.akui.server.service.pojo.UserMoney;
import com.dddqmmx.akui.server.service.UserMoneyService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<UserMoney> moneyList = UserMoneyService.moneyList(1538080366L);
        for (UserMoney userMoney : moneyList){
            System.out.println(userMoney.getMoneyId()+" = "+ userMoney.getNumber());
        }
    }
}
