package com.zzg.tracing.dao;

import com.zzg.tracing.entity.LostPeopleEntity;

import java.sql.Connection;
import java.util.List;

public interface LostPeopleDao {

    public String addLostPeople(Connection connection, LostPeopleEntity entity);


    public List<LostPeopleEntity> selectLostsByid(Connection connection, int user_id);


}
