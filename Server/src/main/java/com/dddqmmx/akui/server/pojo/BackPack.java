package com.dddqmmx.akui.server.pojo;

import java.io.Serializable;

public class BackPack implements Serializable {
    private long qq;
    private Items items;
    private int number;

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
