package com.dddqmmx.akui.ai.chat;

import com.dddqmmx.akui.ai.Control;
import com.dddqmmx.akui.ai.Main;
import com.dddqmmx.akui.ai.game.Game;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.MessageChain;
import org.json.JSONObject;

public class Reply {

    MessageEvent event;

    public Reply(MessageEvent event){
        this.event =event;
    }

    public void game(){
        long qq = event.getSender().getId();
        String msg = event.getMessage().contentToString();
        Game game = new Game(event);
        switch (msg) {
            case "菜单":
                game.showMainMenu();
                break;
            case "每日签到":
                break;
            case "签到":
                game.signIn(qq);
                break;
            case "开发团队":
                game.developmentTeam();
                break;
            case "信息查看":
                game.getInfo();
            case "我的信息":
                game.userInfo(qq);
                break;
            case "系统商店":
                game.systemStore();
                break;
        }
        if (msg.indexOf(' ')!=-1){
            String[] msgs = msg.split(" ");
            if (msgs[0].equals("sudo")){
                if (Control.isAdmin(qq)){
                    switch (msgs[1]) {
                        case "help":
                            send("傻逼,自己做的软件还不知道怎么用???");
                            break;
                        case "":
                            break;
                        default:
                            send("未知指令,请发送sudo help查看帮助");
                    }
                }else {
                    send("你不是管理员,不能使用该命令");
                }
            }
        }
    }

    public void send(String msg){
        event.getSubject().sendMessage(msg);
    }

    public void send(MessageChain messageChain){
        event.getSubject().sendMessage(messageChain);
    }

    public void sendForServer(String commend){
        Main.server.seed(commend);
    }

}
