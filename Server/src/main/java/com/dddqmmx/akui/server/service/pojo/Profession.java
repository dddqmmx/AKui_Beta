package com.dddqmmx.akui.server.service.pojo;

import java.io.Serializable;

public class Profession implements Serializable {
    private long qq;
    private String name;

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
