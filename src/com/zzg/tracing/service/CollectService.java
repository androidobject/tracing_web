package com.zzg.tracing.service;

import com.zzg.tracing.dao.CollectDao;
import com.zzg.tracing.dao.impl.CollectDaoImpl;
import com.zzg.tracing.entity.CollectEntity;
import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public class CollectService {


    private CollectDao dao = new CollectDaoImpl();


    /**
     * 收藏丢失人信息
     *
     * @param entity
     * @return
     */
    public boolean collect(CollectEntity entity) {

        Connection connection = null;
        connection = ConnectionFactory.getInstance().makeConnection();

        boolean collect = dao.collect(connection, entity);

        return collect;

    }


    /**
     * 取消收藏丢失人信息
     *
     * @param
     * @return
     */
    public boolean unCollect(int lost_info_id, int collect_user_id) {

        Connection connection = null;
        connection = ConnectionFactory.getInstance().makeConnection();

        boolean collect = dao.unCollect(connection, lost_info_id, collect_user_id);

        return collect;

    }


    /**
     * 查询我的收藏列表
     *
     * @param user_id
     * @return
     */
    public List<LostInfoEntity> getCollectList(int user_id) {

        Connection connection = ConnectionFactory.getInstance().makeConnection();

        List<LostInfoEntity> collectList = dao.getCollectList(connection, user_id);


        return collectList;
    }


}
