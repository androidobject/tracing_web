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
     * @return
     */

    boolean saveLostInfo(Connection connection, String user_id, String lost_people_id, String send_by_phone, String lost_area, String issued_des);

    /**
     * 查询丢失人列表、首页展示
     *
     * @param connection
     * @param area       地区
     * @param page       第几页
     * @return
     */

    PageEntity selectLostList(Connection connection, String area, String page);


    /**
     * 通过userid 获取当前发布人的发布信息
     */

    List<LostInfoEntity> selectLostListByUid(Connection connection, int user_id);


}
