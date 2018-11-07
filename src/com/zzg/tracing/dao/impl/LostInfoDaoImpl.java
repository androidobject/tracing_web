package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.LostInfoDao;
import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.entity.LostPeopleEntity;
import com.zzg.tracing.entity.PageEntity;
import com.zzg.tracing.entity.UserEntity;
import com.zzg.tracing.utils.SqlTableUtils;
import com.zzg.tracing.utils.TextUtils;
import com.zzg.tracing.utils.TimeUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LostInfoDaoImpl implements LostInfoDao {


    @Override
    public boolean saveLostInfo(Connection connection, String user_id, String lost_people_id, String send_by_phone, String lost_area, String issued_des) {
        String sql = "insert  into lost_info (send_id,lost_people_id,issued_des,send_by_phone,lost_area,create_time)values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(user_id));
            ps.setInt(2, Integer.parseInt(lost_people_id));
            ps.setString(3, issued_des);
            ps.setString(4, send_by_phone);
            if (TextUtils.isEmpty(lost_area)) {
                lost_area = "全国";
            }
            ps.setString(5, lost_area);
            ps.setString(6, TimeUtils.getCurrentTime());
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
        int currentpage = Integer.parseInt(page);
        if (currentpage <= 0) {
            currentpage = 1;
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
            ArrayList<LostInfoEntity> mList = new ArrayList<>();
            while (rs.next()) {
                LostInfoEntity lostInfoEntity = new LostInfoEntity();
                lostInfoEntity.setId(rs.getInt("id"));
                lostInfoEntity.setLost_area(rs.getString("lost_area"));
                lostInfoEntity.setCreate_time(rs.getString("create_time"));
                lostInfoEntity.setSend_by_phone(rs.getString("send_by_phone"));
                lostInfoEntity.setLook_times(rs.getInt("look_times"));
                lostInfoEntity.setSend_id(rs.getInt("send_id"));
                lostInfoEntity.setCollect_times(rs.getInt("collect_times"));
                lostInfoEntity.setCommit_times(rs.getInt("commit_times"));
                //查询发布人信息

                UserEntity userEntity = new UserEntity();
                String sqlUser = "select * from user where id=?";
                PreparedStatement psuser = connection.prepareStatement(sqlUser);
                psuser.setInt(1, rs.getInt("send_id"));
                ResultSet rsUser = psuser.executeQuery();
                if (rsUser.next()) {
                    SqlTableUtils.setUserEntity(userEntity, rsUser, 1);
                    lostInfoEntity.setUserEntity(userEntity);
                }

                //查询丢失儿童信息
                LostPeopleEntity lostPeopleEntity = new LostPeopleEntity();
                String sqlLost = "select * from lost_people where id=?";
                PreparedStatement psLosts = connection.prepareStatement(sqlLost);
                psLosts.setInt(1, rs.getInt("lost_people_id"));
                ResultSet rsLosts = psLosts.executeQuery();
                if (rsLosts.next()) {
                    SqlTableUtils.setLostPeopleInfo(connection, lostPeopleEntity, rsLosts);
                    lostInfoEntity.setLostPeople(lostPeopleEntity);
                }
                mList.add(lostInfoEntity);
            }
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

//            tableList = SqlTableUtils.getTableList(resultSet);
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
