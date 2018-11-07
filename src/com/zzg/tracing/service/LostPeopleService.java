package com.zzg.tracing.service;

import com.zzg.tracing.dao.LostPeopleDao;
import com.zzg.tracing.dao.impl.LostPeopleDaoImpl;
import com.zzg.tracing.entity.LostPeopleEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public class LostPeopleService {
    private LostPeopleDao dao = new LostPeopleDaoImpl();

    /**
     * 添加丢失人信息
     *
     * @param entity
     * @return
     */
    public String addLostPeople(LostPeopleEntity entity) {
        Connection connection = ConnectionFactory.getInstance().makeConnection();
        String msg = dao.addLostPeople(connection, entity);
        return msg;
    }

    /**
     * 查询丢失人信息
     */

    public List<LostPeopleEntity> selectLostsById(int user_id) {
        Connection connection = ConnectionFactory.getInstance().makeConnection();
        List<LostPeopleEntity> ml = dao.selectLostsByid(connection, user_id);
        return ml;
    }

    /**
     * 查询所有的丢失儿童
     */
    public List<LostPeopleEntity> selectAllLosts() {
        Connection connection = ConnectionFactory.getInstance().makeConnection();
        List<LostPeopleEntity> ml = dao.selectAllLosts(connection);
        return ml;
    }


}
