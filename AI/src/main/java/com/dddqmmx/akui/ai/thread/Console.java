package com.dddqmmx.akui.ai.thread;

import java.util.Scanner;

public class Console extends Thread{
    Scanner scanner = new Scanner(System.in);

    boolean flag = true;

    public void run(){
        while (flag) {
            String command = scanner.next();
            switch (command){
                case "exit":
                case "stop":
                case "close":
                    System.out.println("程序正在关闭");
                    System.exit(0);;
                    break;
                case "help":
                    System.out.println("啥B,自己写的软件都他妈的不知道怎么用?");
                    break;
                default:
                    System.out.println("未知指令或无法识别,请发送[help]获取使用帮助");
                    break;
            }
        }
    }
}
