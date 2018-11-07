package com.zzg.tracing.dao;

import com.zzg.tracing.entity.LostPeopleEntity;

import java.sql.Connection;
import java.util.List;

public interface LostPeopleDao {

    /**
     * 添加丢失人信息
     *
     * @param connection
     * @param entity
     * @return
     */
    String addLostPeople(Connection connection, LostPeopleEntity entity);


    /**
     * 查询个人丢失人列表
     *
     * @param connection
     * @param user_id
     * @return
     */
    List<LostPeopleEntity> selectLostsByid(Connection connection, int user_id);


    /**
     * 查询个人丢失人列表
     *
     * @param connection
     * @return
     */
    List<LostPeopleEntity> selectAllLosts(Connection connection);

}
