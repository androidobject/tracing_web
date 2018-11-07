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
     * @return
     */
    public boolean saveLostInfo(String user_id,String lost_people_id,String send_by_phone,String lost_area,String issued_des) {

        Connection connection = ConnectionFactory.getInstance().makeConnection();

        boolean b = dao.saveLostInfo(connection, user_id,lost_people_id,send_by_phone,lost_area,issued_des);

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


    /**
     * 查询当前用户发布的信息
     */

    public List<LostInfoEntity> selectInfoByUid(int uid) {


        Connection connection = ConnectionFactory.getInstance().makeConnection();

        List<LostInfoEntity> lostInfoEntities = dao.selectLostListByUid(connection, uid);

        return lostInfoEntities;

    }


}
