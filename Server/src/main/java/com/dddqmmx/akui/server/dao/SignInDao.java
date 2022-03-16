package com.dddqmmx.akui.server.dao;

import java.util.Date;

public interface SignInDao {
    int haveSingIn(long qq);
    Date getSingInTime(long qq);
    int setSingInTime(long qq,Date time);
}
