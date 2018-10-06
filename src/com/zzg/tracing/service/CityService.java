package com.zzg.tracing.service;

import com.zzg.tracing.dao.CityDao;
import com.zzg.tracing.dao.impl.CityDaoImpl;
import com.zzg.tracing.entity.CityEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public class CityService {

    private CityDao dao = new CityDaoImpl();


    /**
     * 获取城市列表
     *
     * @return
     */
    public List<CityEntity> getCityList() {
        Connection connection = ConnectionFactory.getInstance().makeConnection();
        List<CityEntity> cityList = dao.getCityList(connection);
        return cityList;
    }


}
