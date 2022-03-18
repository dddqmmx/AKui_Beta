package com.dddqmmx.akui.ai.thread;

import com.dddqmmx.akui.ai.chat.Reply;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.utils.BotConfiguration;

public class AI extends Thread {

    public long qq;
    public String pass;

    public Bot bot;     //机器人对象

    public AI(){
        this(3365098730L,"liyan745921",new BotConfiguration() {{
            fileBasedDeviceInfo();
            setProtocol(MiraiProtocol.ANDROID_PHONE);
        }});
    }

    public AI(long qq, String pass, BotConfiguration botConfiguration){
        this.qq = qq;
        this.pass = pass;
        bot = BotFactory.INSTANCE.newBot(this.qq,this.pass,botConfiguration);
    }

    @Override
    public void run() {
        super.run();
        bot.login();
        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, (event)->{
            Reply reply = new Reply(event);
        });  //监听私聊消息
        bot.getEventChannel().subscribeAlways(GroupMessageEvent.class, (event)->{
            Reply reply = new Reply(event);
            reply.game();
            reply.chartReply(event.getMessage().toString(),event.getSender());
        });  //监听群消息
    }
}