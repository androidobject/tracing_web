package com.zzg.tracing.dao;

import com.zzg.tracing.entity.LostInfoEntity;

import java.sql.Connection;

public interface LostInfoDao {

    /**
     * 保存丢失人信息
     * @param connection
     * @param entity
     * @return
     */

    public boolean saveLostInfo(Connection connection, LostInfoEntity entity);

}
