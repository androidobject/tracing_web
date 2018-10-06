package com.zzg.tracing.service;

import com.zzg.tracing.dao.LostInfoDao;
import com.zzg.tracing.dao.impl.LostInfoDaoImpl;
import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.entity.PageEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

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

    /**
     * 查询丢失人列表
     */

    public PageEntity selectLostList(String area, String page) {
        Connection connection = ConnectionFactory.getInstance().makeConnection();
        PageEntity pageEntity = dao.selectLostList(connection, area, page);

        return pageEntity;
    }


}
