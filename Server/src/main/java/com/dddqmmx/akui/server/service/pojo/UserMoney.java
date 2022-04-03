package com.dddqmmx.akui.server.service.pojo;

import java.io.Serializable;

public class UserMoney implements Serializable {
    private long qq;
    private int moneyId;
    private int number;

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public int getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(int moneyId) {
        this.moneyId = moneyId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
