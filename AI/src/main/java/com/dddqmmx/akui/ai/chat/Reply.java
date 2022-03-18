package com.dddqmmx.akui.ai.chat;

import com.dddqmmx.akui.ai.Control;
import com.dddqmmx.akui.ai.Main;
import com.dddqmmx.akui.ai.game.Game;
import com.dddqmmx.akui.ai.util.Upload;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.internal.message.LightAppStruct;
import net.mamoe.mirai.message.code.MiraiCode;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.MusicKind;
import net.mamoe.mirai.message.data.MusicShare;

import java.io.IOException;
import java.net.URL;

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

    public void chartReply(String msg, Contact contact){
        //简单判断
        System.out.println(msg);
        switch(msg){
            case "test":
                send("测试用文本消息");
                break;
            case "点歌 冬の花":
                //MessageChain messageChain = MiraiCode.deserializeMiraiCode("[mirai:origin:MUSIC_SHARE]MusicShare(kind=NeteaseCloudMusic, title=カタオモイ(Cover Aimer) (单相思), summary=夏色まつり, jumpUrl=https://y.music.163.com/m/song?id=1471767263&uct=9pqh4%2FZCB%2F7G%2FIuUvEytRQ%3D%3D&app_version=8.7.03, pictureUrl=http://p1.music.126.net/BQ9bhzDnu3uJrK4zzZ568w==/109951165243543070.jpg, musicUrl=http://music.163.com/song/media/outer/url?id=1471767263&userid=3338163624&sc=wmv, brief=[分享]カタオモイ(Cover Aimer) (单相思))\n" + "[分享]カタオモイ(Cover Aimer) (单相思)");
                //
                MusicShare musicShare= new MusicShare(MusicKind.NeteaseCloudMusic,
                        "冬の花 (日剧《后妻业》主题曲 ； ドラマ『後妻業』主題歌",
                        "宮本浩次",
                        "https://y.music.163.com/m/song?id=1345485069&uct=9pqh4%2FZCB%2F7G%2FIuUvEytRQ%3D%3D&app_version=8.7.03",
                        "http://p2.music.126.net/IARWNTyCr1s8tkbgd3V8QA==/109951163919087485.jpg",
                        "http://music.163.com/song/media/outer/url?id=1345485069&userid=3338163624&sc=wmv");
                send(new MessageChainBuilder()
                        .append("我真的怀疑有些人闲的程度啊")
                        .append(musicShare)
                        .build()
                );
                //send(chain);
        }
        //复杂判断
        if (msg.matches(".*010.*")) {
            URL url = this.getClass().getResource("/ybb.png");
            try {
                if (url != null) {
                    send(new MessageChainBuilder()
                            .append("我真的怀疑有些人闲的程度啊")
                            .append(Upload.getImage(url.openStream(),contact))
                            .build()
                    );
                }
            } catch (IOException e) {
                e.printStackTrace();
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
