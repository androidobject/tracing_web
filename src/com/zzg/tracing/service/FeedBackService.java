package com.zzg.tracing.service;

import com.zzg.tracing.dao.FeedBackDao;
import com.zzg.tracing.dao.impl.FeedBackDaoImpl;
import com.zzg.tracing.entity.FeedBackEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;

public class FeedBackService {


    /**
     * 意见反馈
     *
     * @param entity
     */
    public String feedback(FeedBackEntity entity) {


        FeedBackDao dao = new FeedBackDaoImpl();

        String msg = "";

        Connection connection = null;

        try {
            connection = ConnectionFactory.getInstance().makeConnection();

            boolean login = dao.feedBack(connection, entity);
            if (login) {
                msg = "ok";
            } else {
                msg = "未知错误";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "未知错误";
        }

        return msg;


    }


}
