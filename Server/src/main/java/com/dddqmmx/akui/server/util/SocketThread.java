package com.dddqmmx.akui.server.util;

import com.dddqmmx.akui.server.Reply;

import java.io.*;
import java.net.Socket;

public class SocketThread extends Thread {
    String ip;
    public Socket socket;

    PrintWriter pw = null;
    BufferedReader br = null;

    public SocketThread(Socket socket) {
        this.socket = socket;
        ip = socket.getInetAddress().getHostAddress();
        System.out.println("收到连接,IP:" + socket.getInetAddress().getHostAddress());
    }

    public void run() {
        try {
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            while((line = br.readLine()) != null){
                Reply reply = new Reply();
                reply.socket(line,this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (pw != null) {
                    pw.close();
                }
                if (br != null) {
                    br.close();
                }
                System.out.println(ip+"断开连接");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void send(String msg){
        System.out.println(msg);
        pw.println(msg);
        pw.flush();
    }
}