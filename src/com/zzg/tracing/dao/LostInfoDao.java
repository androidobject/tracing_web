package com.zzg.tracing.dao;

import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.entity.PageEntity;

import java.sql.Connection;
import java.util.List;

public interface LostInfoDao {

    /**
     * 保存丢失人信息
     *
     * @param connection
     * @param entity
     * @return
     */

    public boolean saveLostInfo(Connection connection, LostInfoEntity entity);

    /**
     * 查询丢失人列表、首页展示
     *
     * @param connection
     * @param area       地区
     * @param page       第几页
     * @return
     */

    public PageEntity selectLostList(Connection connection, String area, String page);


    /**
     * 通过userid 获取当前发布人的发布信息
     */

    public List<LostInfoEntity> selectLostListByUid(Connection connection, int user_id);


}
