package com.zzg.tracing.dao;

import com.zzg.tracing.entity.CityEntity;

import java.sql.Connection;
import java.util.List;

public interface CityDao {

    public List<CityEntity> getCityList(Connection connection);

}
