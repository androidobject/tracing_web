package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.FeedBackDao;
import com.zzg.tracing.entity.FeedBackEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedBackDaoImpl implements FeedBackDao {


    @Override
    public boolean feedBack(Connection connection, FeedBackEntity entity) {
        String sql = "insert  into feedback(create_time,content,contact,feedback_by_phone,user_id) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getCreate_time());
            ps.setString(2, entity.getContent());
            ps.setString(3, entity.getContact());
            ps.setString(4, entity.getFeedback_by_phone());
            ps.setString(5, entity.getUser_id());
            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }


}
