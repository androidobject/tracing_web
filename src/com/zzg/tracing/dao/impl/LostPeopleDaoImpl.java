package com.zzg.tracing.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zzg.tracing.dao.LostPeopleDao;
import com.zzg.tracing.entity.LostPeopleEntity;
import com.zzg.tracing.utils.SqlTableUtils;
import com.zzg.tracing.utils.TimeUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LostPeopleDaoImpl implements LostPeopleDao {

    @Override
    public String addLostPeople(Connection connection, LostPeopleEntity entity) {
        String result = "";

        String sql = "insert  into lost_people(name,lost_time,lost_des,lost_area,lost_high" +
                ",pic_file,lost_weight,create_time,create_by_user,nickname,lost_age,lost_sex,photo) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLost_time());
            ps.setString(3, entity.getLost_des());
            ps.setString(4, entity.getLost_area());
            ps.setString(5, entity.getLost_high());
            ps.setString(6, entity.getPic_file());
            ps.setString(7, entity.getLost_weight());
            ps.setString(8, TimeUtils.getCurrentTime());
            ps.setInt(9, entity.getCreate_by_user());
            ps.setString(10, entity.getNickname());
            ps.setString(11, entity.getLost_age());
            ps.setString(12, entity.getLost_sex());
            ps.setString(13, entity.getPhoto());

            int i = ps.executeUpdate();
            if (i == 1) {
                result = "添加信息成功";
            } else {
                result = "添加失败";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = "服务器异常";
        }

        return result;
    }


    @Override
    public List<LostPeopleEntity> selectLostsByid(Connection connection, int user_id) {
        List<LostPeopleEntity> mlist = new ArrayList<>();

        String sql = "select * from lost_people where create_by_user=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LostPeopleEntity entity = new LostPeopleEntity();
                mlist.add(entity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mlist;
    }

    /**
     * 查询所有的丢失人信息
     *
     * @param connection
     * @return
     */
    @Override
    public List<LostPeopleEntity> selectAllLosts(Connection connection) {
        String sql = "select * from lost_people";

        List<LostPeopleEntity> mlist = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LostPeopleEntity entity = new LostPeopleEntity();
                SqlTableUtils.setLostPeopleInfo(connection, entity, rs);
                mlist.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mlist;
    }

}
