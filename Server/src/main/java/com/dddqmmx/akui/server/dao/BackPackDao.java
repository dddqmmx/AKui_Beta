package com.dddqmmx.akui.server.dao;

import com.dddqmmx.akui.server.service.pojo.BackPack;

import java.util.List;

public interface BackPackDao {
    List<BackPack> getBackPack(long qq);
}
