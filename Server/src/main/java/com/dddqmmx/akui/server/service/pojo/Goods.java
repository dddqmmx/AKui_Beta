package com.dddqmmx.akui.server.service.pojo;

import java.io.Serializable;

public class Goods implements Serializable {
    private int itemId;
    private int money;
    private int number;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
