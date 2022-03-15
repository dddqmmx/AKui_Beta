package com.dddqmmx.akui.ai.game;

import com.dddqmmx.akui.ai.Control;
import com.dddqmmx.akui.ai.Main;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.MessageChain;

public class Game {
    MessageEvent event;
    public Game (MessageEvent event){
        this.event = event;
    }
    public void showMainMenu(){
        send("==========阿葵==========\n" +
                  "每日签到||开发团队||信息查看\n" +
                  "使用帮助||管理命令||系统商店\n" +
                  "打工系统||"
        );
    }

    public void signIn(long qq){
           send(Control.singIn(qq));
    }

    public void developmentTeam(){
        send("========开发团队========\n" +
                  "架构 : dddqmmx\n" +
                  "AI : dddqmmx\n" +
                  "服务端 : dddqmmx\n" +
                  "游戏 : dddqmmx\n" +
                  "运营 : dddqmmx\n" +
                  "资金支持 : dddqmmx\n" +
                  "其他 : dddqmmx\n" +
                  "技术支持 : dddqmmx\n" +
                  "该AI基于mirai开源框架\n" +
                  "https://github.com/mamoe/mirai"
        );
    }

    public void getInfo(){
        send("发送[我的信息]查看自己信息");
    }

    public void userInfo(long qq){
        send("========用户信息========\n" +
                Control.userInfo(qq));
    }

    public void systemStore(){
        send("========系统商店========\n" +
                  "小布丁 0 米线\n" +
                  "ASoul成员的骨灰 0 货币\n" +
                  "便宜糖和高级白兰地 1 货币\n" +
                  "替身箭 1 货币\n" +
                  "石鬼面 1 货币\n" +
                  "七海鲨鱼卫衣 999999 货币\n" +
                  "======================\n" +
                  "购买物品指令[购买 商品名 数量]"
        );
    }

    public void send(String msg){
        event.getSubject().sendMessage(msg);
    }

    public void send(MessageChain messageChain){
        event.getSubject().sendMessage(messageChain);
    }
}
