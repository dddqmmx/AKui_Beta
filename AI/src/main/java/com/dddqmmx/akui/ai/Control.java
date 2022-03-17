package com.dddqmmx.akui.ai;

import com.dddqmmx.akui.ai.thread.AI;
import com.dddqmmx.akui.ai.thread.Server;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Control {

    public static Map<Long, AI> aiMap = new HashMap<>();

    public static void newAI(){
        newAI(new AI());
    }

    public static void newAI(AI ai){
        aiMap.put(ai.qq,ai);
    }

    public static void startAI(){
        startAI(3365098730L);
    }

    public static void startAI(long qq){
        AI startAI = aiMap.get(qq);
        startAI.start();
    }

    public static boolean isAdmin(long qq){
        JSONObject json = new JSONObject();
        json.put("command","isAdmin");
        json.put("qq",qq);
        seedForServer(json.toString());
        String line = null;
        try {
            while((line = Main.server.br.readLine()) != null){
                System.out.println(line);
                return "true".equals(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static String userInfo(long qq){
        JSONObject json = new JSONObject();
        json.put("command","userInfo");
        json.put("qq",qq);
        seedForServer(json.toString());
        String line = null;
        try {
            while((line = Main.server.br.readLine()) != null){
                System.out.println(line);
                return line.replaceAll("CR/LF","\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String singIn(long qq){
        JSONObject json = new JSONObject();
        json.put("command","signIn");
        json.put("qq",qq);
        seedForServer(json.toString());
        String line = null;
        try {
            while((line = Main.server.br.readLine()) != null){
                System.out.println(line);
                return line;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void seedForServer(String msg){
        Main.server.seed(msg);
    }
}
