package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.LostInfoDao;
import com.zzg.tracing.entity.LostInfoEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LostInfoDaoImpl implements LostInfoDao {
    @Override
    public boolean saveLostInfo(Connection connection, LostInfoEntity entity) {
        String sql = "INSERT  INTO lost_info (lost_name,lost_age,lost_sex,lost_high,last_see_time,lost_area,create_time," +
                "contact_name,contact_phone,contact_wx,contact_address,send_by_phone,look_time,send_id)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getLost_name());
            ps.setString(2, entity.getLost_age());
            ps.setString(3, entity.getLost_sex());
            ps.setString(4, entity.getLost_high());
            ps.setString(5, entity.getLast_see_time());
            ps.setString(6, entity.getLost_area());
            ps.setString(7, entity.getCreate_time());
            ps.setString(8, entity.getContact_name());
            ps.setString(9, entity.getContact_phone());
            ps.setString(10, entity.getContact_wx());
            ps.setString(11, entity.getContact_address());
            ps.setString(12, entity.getSend_by_phone());
            ps.setInt(13, entity.getLook_time());
            ps.setString(14, entity.getSend_id());
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
