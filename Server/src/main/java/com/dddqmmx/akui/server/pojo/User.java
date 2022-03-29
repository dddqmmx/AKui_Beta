package com.dddqmmx.akui.server.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private long qq;

    private boolean isAdmin;

    public long getQQ() {
        return qq;
    }

    public void setQQ(long qq) {
        this.qq = qq;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
