package com.dddqmmx.akui.server.pojo;

import java.io.Serializable;
import java.util.Date;

public class SignIn implements Serializable {
    private int qq ;
    private Date time;

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
