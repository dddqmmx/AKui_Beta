package com.dddqmmx.akui.server.service.pojo;

import java.io.Serializable;

public class BackPack implements Serializable {
    private long qq;
    private int itemId;
    private int number;

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}