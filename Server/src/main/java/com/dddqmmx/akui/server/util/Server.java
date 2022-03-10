package com.dddqmmx.akui.server.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    public Socket socket;
    public ServerSocket serverSocket;
    public int port;
    public void startServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println(
            "服务器初始化成功\n" +
            "端口 : "+serverSocket.getLocalPort()
        );
        //noinspection InfiniteLoopStatement
        while (true) {
            socket = serverSocket.accept();
            new SocketThread(socket).start();
        }
    }
    public void getServerInfo() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(
            "本机名称 : " + ip.getHostName()+"\n" +
            "本机ip : " + ip.getHostAddress()
        );
    }
}
