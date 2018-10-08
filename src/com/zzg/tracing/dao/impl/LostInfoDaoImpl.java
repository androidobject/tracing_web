package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.LostInfoDao;
import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.entity.PageEntity;
import com.zzg.tracing.utils.SqlTableUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LostInfoDaoImpl implements LostInfoDao {
    @Override
    public boolean saveLostInfo(Connection connection, LostInfoEntity entity) {
        String sql = "INSERT  INTO lost_info (lost_name,lost_age,lost_sex,lost_high,last_see_time,lost_area,create_time," +
                "contact_name,contact_phone,contact_wx,contact_address,send_by_phone,look_time,send_id,collect_time,commit_time)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(15, entity.getCollect_time());
            ps.setInt(16, entity.getCommit_time());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }


    /**
     * 筛选丢失人列表
     *
     * @param connection
     * @param area       地区
     * @param page       第几页
     * @return 通过id 倒叙查询列表 、全国筛选所有的
     */

    //默认每页10条
    public final int PageNum = 10;

    @Override
    public PageEntity selectLostList(Connection connection, String area, String page) {

        PageEntity pageEnty = new PageEntity();


        int type = -1;
        String sql = "";

        if (area.equals("全国")) {
            type = 0;
            sql = "SELECT * from lost_info order by id DESC";
        } else {
            sql = "SELECT * from lost_info  where lost_area=? order by id DESC ";
            type = 1;
        }
        int totolNum = selectTotalNum(connection, area, page);
        int totalPage = (totolNum + PageNum - 1) / PageNum;
        //设置总页数
        pageEnty.setTotalPage(totalPage);

        int currentpage = 1;
        try {
            currentpage = Integer.parseInt(page);
            if (currentpage <= 0) {
                currentpage = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (currentpage <= totalPage) {
            sql = sql + " LIMIT " + (currentpage - 1) * PageNum + "," + PageNum;
        } else {
            throw new RuntimeException("参数错误!");

        }
        //设置当前页数
        pageEnty.setCurrentPage(currentpage);

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            if (type == 1) {
                ps.setString(1, area);
            }
            ResultSet rs = ps.executeQuery();
            //转换为list
            List<LostInfoEntity> mList = SqlTableUtils.getTableList(rs);

            pageEnty.setMlist(mList);
            return pageEnty;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pageEnty;
    }

    /**
     * 通过send_Id 查询所有发布的信息
     *
     * @param connection
     * @param user_id
     * @return
     */

    @Override
    public List<LostInfoEntity> selectLostListByUid(Connection connection, int user_id) {
        String sql = "SELECT * from lost_info where send_id=?";
        List<LostInfoEntity> tableList = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user_id);

            ResultSet resultSet = ps.executeQuery();

            tableList = SqlTableUtils.getTableList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }


    /**
     * 查询总条数
     *
     * @param connection
     * @param area
     * @param page
     * @return
     */
    public int selectTotalNum(Connection connection, String area, String page) {

        int type = -1;
        String sql = "";
        int rowCount = 0;

        if (area.equals("全国")) {
            type = 0;
            sql = "SELECT count(*) rec from lost_info ";
        } else {
            sql = "SELECT count(*) rec from lost_info  where lost_area=? ";
            type = 1;
        }

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            if (type == 1) {
                ps.setString(1, area);
            }
            ResultSet resultSet = ps.executeQuery();


            while (resultSet.next()) {
                rowCount = resultSet.getInt("rec");
            }

            return rowCount;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowCount;

    }


}
