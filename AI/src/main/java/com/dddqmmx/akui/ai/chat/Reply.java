package com.dddqmmx.akui.ai.chat;

import com.dddqmmx.akui.ai.Control;
import com.dddqmmx.akui.ai.Main;
import com.dddqmmx.akui.ai.game.Game;
import com.dddqmmx.akui.ai.util.Upload;
import com.dddqmmx.akui.ai.util.Web;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.MusicKind;
import net.mamoe.mirai.message.data.MusicShare;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

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
                game.signInInfo();
                break;
            case "签到":
                game.signIn(qq);
                break;
            case "开发团队":
                game.developmentTeam();
                break;
            case "信息查看":
                game.getInfo();
                break;
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
                        case "closeAI":
                            send("正在关闭");
                            System.exit(0);
                            break;
                        default:
                            send("未知指令,请发送sudo help查看帮助");
                    }
                }else {
                    send("你不是管理员,不能使用该命令");
                }
            }else if (msgs[0].equals("点歌")){
                String name = msgs[1];
                for (int i = 2; i< msgs.length;i++){
                    name += " " + msgs[i];
                }
                System.out.println(name);
                try {
                    JSONObject json = new JSONObject(Web.loadWeb("http://49.232.209.180:20041/api/search/song?keyword="+URLEncoder.encode(name, StandardCharsets.UTF_8)+"&type=wy&n=1"));
                    JSONObject musicJson = json.getJSONArray("data").getJSONObject(0);
                    MusicShare musicShare= new MusicShare(MusicKind.NeteaseCloudMusic,
                            musicJson.getString("media_name"),
                            musicJson.getString("author_name"),
                            "https://y.music.163.com/m/song?id=1345485069",
                            musicJson.getString("imgUrl"),
                            musicJson.getString("songUrl"));
                    send(new MessageChainBuilder()
                            .append(musicShare)
                            .build()
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (msgs[0].equals("购买")){
                if (msgs.length < 2 || isInt(msgs[2])){
                    String name = msgs[1];
                    int number=Integer.parseInt(msgs[2]);
                    send(Control.buy(qq,name,number));
                }else {
                    send("你他妈能不能好好填参数");
                }
            }
        }
    }

    public void chartReply(String msg, Contact contact){
        //简单判断
        // System.out.println(msg);
        switch(msg){
            case "test":
                send("测试用文本消息");
                break;
            case "我需要被肯定":
                send("压力马斯内");
        }
        //复杂判断
       /* if (msg.matches(".*010.*")) {
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
        } else if(msg.matches(".*阿梓.*爷爷.*")){
            URL url = this.getClass().getResource("/zhaoRuoYang.jpg");
            try {
                if (url != null) {
                    send(new MessageChainBuilder()
                            .append("米线!!!!")
                            .append(Upload.getImage(url.openStream(),contact))
                            .build()
                    );
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
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

    private static boolean isInt(String str) {
        Pattern pattern = Pattern.compile("0|([-]?[1-9][0-9]*)");
        return pattern.matcher(str).matches();
    }
}
