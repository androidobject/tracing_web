package com.zzg.tracing.service;

import com.zzg.tracing.dao.EssayDao;
import com.zzg.tracing.dao.FeedBackDao;
import com.zzg.tracing.dao.impl.EssayDaoImpl;
import com.zzg.tracing.dao.impl.FeedBackDaoImpl;
import com.zzg.tracing.entity.EssayEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EssayService {


    private EssayDao dao = new EssayDaoImpl();


    /**
     * 获取文章列表
     *
     * @return
     */
    public List<EssayEntity> getEssayList(int num) {

        List<EssayEntity> essay = new ArrayList<>();
        Connection connection = null;

        try {
            connection = ConnectionFactory.getInstance().makeConnection();

            essay = dao.getEssay(connection, num);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return essay;


    }


}
