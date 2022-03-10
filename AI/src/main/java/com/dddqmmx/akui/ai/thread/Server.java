package com.dddqmmx.akui.ai.thread;

import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

@SuppressWarnings("BusyWait")
public class Server extends Thread {

    public boolean connect = false;
    String protocol;
    int port;

    Socket socket = null;
    public PrintWriter pw = null;
    public BufferedReader br = null;

    long tryFrequency = 0;

    public Server(){
        protocol = "127.0.0.1";
        port = 2077;
    }

    public Server(String protocol,int port){
        this.protocol = protocol;
        this.port = port;
    }

    @Override
    public void run() {
        super.run();
        connectServer();
    }

    public void connectServer(){
        connect = initialization();
        while (!connect){
            System.out.println("服务器连接失败尝试次数"+(++tryFrequency));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            connect = initialization();
        }
        System.out.println("服务器已连接");
    }

    public boolean initialization(){
        try {
            socket = new Socket(protocol,port);
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void seed(String msg){
        System.out.println("发送 : "+msg);
        pw.println(msg);
        pw.flush();
    }

}