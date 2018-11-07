package com.zzg.tracing.utils;

import com.alibaba.fastjson.JSON;
import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.entity.LostPeopleEntity;
import com.zzg.tracing.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取 sql 中的字段、统一获取
 */

public class SqlTableUtils {


    /**
     * 获取 lostinf表数据填充到list
     *
     * @param rs
     * @return
     */
//    public static List<LostInfoEntity> getTableList(ResultSet rs) throws SQLException {
//
//
//
//        while (rs.next()) {
//
//            lostInfoEntity.setId(rs.getInt("id"));
//            lostInfoEntity.setLost_name(rs.getString("lost_name"));
//            lostInfoEntity.setLost_age(rs.getString("lost_age"));
//            lostInfoEntity.setLost_sex(rs.getString("lost_sex"));
//            lostInfoEntity.setLost_high(rs.getString("lost_high"));
//            lostInfoEntity.setLast_see_time(rs.getString("last_see_time"));
//            lostInfoEntity.setLost_area(rs.getString("lost_area"));
//            lostInfoEntity.setCreate_time(rs.getString("create_time"));
//            lostInfoEntity.setContact_name(rs.getString("contact_name"));
//            lostInfoEntity.setContact_phone(rs.getString("contact_phone"));
//            lostInfoEntity.setContact_wx(rs.getString("contact_wx"));
//            lostInfoEntity.setContact_address(rs.getString("contact_address"));
//            lostInfoEntity.setSend_by_phone(rs.getString("send_by_phone"));
//            lostInfoEntity.setLook_time(rs.getInt("look_time"));
//            lostInfoEntity.setSend_id(rs.getString("send_id"));
//            lostInfoEntity.setCollect_time(rs.getInt("collect_time"));
//            lostInfoEntity.setCommit_time(rs.getInt("commit_time"));
//            mList.add(lostInfoEntity);
//        }
//
//        return mList;
//
//    }

    /**
     * 用户表名称统一处理
     * <p>
     * type 0 .后台管理页面、type1.app 首页列表
     */

    public static void setUserEntity(UserEntity model, ResultSet rs, int type) throws SQLException {

        if (type == 0) {
            model.setCreate_time(rs.getString("create_time"));
            model.setRigister_by_phone(rs.getString("rigister_by_phone"));
            model.setLast_login_time(rs.getString("last_login_time"));
            model.setPassword(rs.getString("password"));
        } else if (type == 1) {

        }
        model.setId(rs.getInt("id"));
        model.setPhone(rs.getString("phone"));
        model.setUser_name(rs.getString("user_name"));
        model.setPhoto(rs.getString("photo"));
        model.setAddress(rs.getString("address"));
        model.setWeixin(rs.getString("weixin"));
    }


    /**
     * 查询儿童信息列表信息填充
     */

    public static void setLostPeopleInfo(Connection connection, LostPeopleEntity entity, ResultSet rs) throws SQLException {
        entity.setId(rs.getInt("id"));
        entity.setName(rs.getString("name"));
        entity.setLost_time(rs.getString("lost_time"));
        entity.setLost_des(rs.getString("lost_des"));
        entity.setLost_area(rs.getString("lost_area"));
        entity.setLost_high(rs.getString("lost_high"));
        entity.setLost_weight(rs.getString("lost_weight"));
        entity.setCreate_time(rs.getString("create_time"));
        entity.setNickname(rs.getString("nickname"));
        entity.setLost_age(rs.getString("lost_age"));
        entity.setPhoto(rs.getString("photo"));
        //查询图片集
        String ids = rs.getString("pic_file");
        String sqlUrl = "select file_url from file where lost_people_id in (" + ids + ")";

        PreparedStatement psFile = connection.prepareStatement(sqlUrl);

        ResultSet rsF = psFile.executeQuery();
        List<String> fileList = new ArrayList<>();
        if (rsF.next()) {
            fileList.add(rsF.getString("file_url"));
        }
        String allURL = JSON.toJSONString(fileList);
        entity.setPic_file(allURL);

    }


}
