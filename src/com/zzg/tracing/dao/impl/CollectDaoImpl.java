package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.CollectDao;
import com.zzg.tracing.entity.CollectEntity;
import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.utils.SqlTableUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectDaoImpl implements CollectDao {


    /**
     * 收藏丢失信息
     *
     * @param connection
     * @param entity
     * @return
     */
    @Override
    public boolean collect(Connection connection, CollectEntity entity) {

        boolean isCollect = chekCollect(connection, entity.getLost_info_id(), entity.getCollect_user_id());

        if (!isCollect) {
            String sql = "INSERT  into  collect (lost_info_id,collect_time,collect_by_phone,collect_user_id)values (?,?,?,?)";
            try {
                connection.setAutoCommit(false);
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, entity.getLost_info_id());
                ps.setString(2, entity.getCollect_time());
                ps.setString(3, entity.getCollect_by_phone());
                ps.setInt(4, entity.getCollect_user_id());
                int i = ps.executeUpdate();

                String selectNum = "update  lost_info  set collect_time=collect_time+1  where id=" + entity.getLost_info_id();
                PreparedStatement psCollectNum = connection.prepareStatement(selectNum);
                int i1 = psCollectNum.executeUpdate();


                if (i == 1 && i1 == 1) {
                    connection.commit();
                    return true;
                } else {
                    throw new RuntimeException("收藏失败,信息不存在！");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        } else {

            throw new RuntimeException("已经收藏该信息！");

        }

        return false;
    }

    /**
     * 检查是否收藏该信息
     *
     * @param connection
     * @param lost_info_id
     * @param collect_user_id
     * @return
     */

    public boolean chekCollect(Connection connection, int lost_info_id, int collect_user_id) {

        String sql = "SELECT * from collect where lost_info_id=? and collect_user_id=?";
        boolean isCollect = false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, lost_info_id);
            ps.setInt(2, collect_user_id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                isCollect = true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }


        return isCollect;
    }

    /**
     * 取消收藏
     *
     * @param connection
     * @param lost_info_id
     * @param collect_user_id
     * @return
     */
    @Override
    public boolean unCollect(Connection connection, int lost_info_id, int collect_user_id) {

        boolean isCollect = chekCollect(connection, lost_info_id, collect_user_id);

        if (isCollect) {

            try {
                connection.setAutoCommit(false);
                String sql = "delete  from collect where lost_info_id=? and collect_user_id=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, lost_info_id);
                ps.setInt(2, collect_user_id);
                int i = ps.executeUpdate();

                String selectNum = "update  lost_info  set collect_time=collect_time-1  where id=" + lost_info_id;
                PreparedStatement psCollectNum = connection.prepareStatement(selectNum);
                int i1 = psCollectNum.executeUpdate();

                if (i == 1 && i1 == 1) {
                    connection.commit();
                    return true;
                } else {
                    throw new RuntimeException("取消收藏失败,信息不存在！");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        } else {
            throw new RuntimeException("未找到该收藏记录！");
        }

        return false;
    }


    /**
     * 查找收藏列表
     *
     * @param connection
     * @param user_id
     * @return
     */

    @Override
    public List<LostInfoEntity> getCollectList(Connection connection, int user_id) {

        String sql = "SELECT * FROM lost_info WHERE id=ANY(SELECT lost_info_id FROM collect WHERE collect_user_id=?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<LostInfoEntity> tableList = SqlTableUtils.getTableList(rs);
            return tableList;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


}
