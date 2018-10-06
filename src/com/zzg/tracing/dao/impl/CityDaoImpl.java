package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.CityDao;
import com.zzg.tracing.entity.CityEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {
    @Override
    public List<CityEntity> getCityList(Connection connection) {

        List<CityEntity> mlist = new ArrayList<>();

        String sql = "SELECT * from city ORDER by id asc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                CityEntity cityEntity = new CityEntity();
                cityEntity.setId(resultSet.getInt("id"));
                cityEntity.setCity_name(resultSet.getString("city_name"));
                mlist.add(cityEntity);
            }

            return mlist;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mlist;
    }
}
