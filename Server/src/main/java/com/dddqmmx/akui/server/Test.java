package com.dddqmmx.akui.server;

import com.dddqmmx.akui.server.pojo.BackPack;
import com.dddqmmx.akui.server.service.BackPackService;

import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("测试中...");
        //SignInService.signIn(1538080366L);
        List<BackPack> backPackList = BackPackService.getBackPack(1538080366L);
        for (BackPack backPack : backPackList) {
            System.out.println(backPack.getNumber());
        }
    }
}
