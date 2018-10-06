package com.zzg.tracing.dao;

import com.zzg.tracing.entity.CollectEntity;

import java.sql.Connection;

public interface CollectDao {

    /**
     * 收藏丢失人信息
     *
     * @param connection
     * @param entity
     * @return
     */
    public boolean collect(Connection connection, CollectEntity entity);


    /**
     * 检查是否收藏该信息
     */

    public boolean chekCollect(Connection connection, int lost_info_id, int collect_user_id);


    /**
     * 取消收藏丢失人信息
     */

    public boolean unCollect(Connection connection, int lost_info_id, int collect_user_id);


}
