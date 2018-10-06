package com.zzg.tracing.service;

import com.zzg.tracing.dao.LostInfoDao;
import com.zzg.tracing.dao.impl.LostInfoDaoImpl;
import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;

public class IssuedService {

    private LostInfoDao dao = new LostInfoDaoImpl();


    /**
     * 保存丢失人信息
     *
     * @param entity
     * @return
     */
    public boolean saveLostInfo(LostInfoEntity entity) {

        Connection connection = ConnectionFactory.getInstance().makeConnection();

        boolean b = dao.saveLostInfo(connection, entity);

        if (b) {
            return true;
        }

        return false;
    }


}
