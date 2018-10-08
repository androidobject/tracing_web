package com.zzg.tracing.dao;

import com.zzg.tracing.entity.CollectEntity;
import com.zzg.tracing.entity.LostInfoEntity;

import java.sql.Connection;
import java.util.List;

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


    /**
     * 查询收藏人列表
     */

    public List<LostInfoEntity> getCollectList(Connection connection, int user_id);

}
