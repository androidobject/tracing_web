package com.zzg.tracing.utils;

import com.zzg.tracing.entity.LostInfoEntity;

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
    public static List<LostInfoEntity> getTableList(ResultSet rs) throws SQLException {

        ArrayList<LostInfoEntity> mList = new ArrayList<>();

        while (rs.next()) {
            LostInfoEntity lostInfoEntity = new LostInfoEntity();
            lostInfoEntity.setId(rs.getInt("id"));
            lostInfoEntity.setLost_name(rs.getString("lost_name"));
            lostInfoEntity.setLost_age(rs.getString("lost_age"));
            lostInfoEntity.setLost_sex(rs.getString("lost_sex"));
            lostInfoEntity.setLost_high(rs.getString("lost_high"));
            lostInfoEntity.setLast_see_time(rs.getString("last_see_time"));
            lostInfoEntity.setLost_area(rs.getString("lost_area"));
            lostInfoEntity.setCreate_time(rs.getString("create_time"));
            lostInfoEntity.setContact_name(rs.getString("contact_name"));
            lostInfoEntity.setContact_phone(rs.getString("contact_phone"));
            lostInfoEntity.setContact_wx(rs.getString("contact_wx"));
            lostInfoEntity.setContact_address(rs.getString("contact_address"));
            lostInfoEntity.setSend_by_phone(rs.getString("send_by_phone"));
            lostInfoEntity.setLook_time(rs.getInt("look_time"));
            lostInfoEntity.setSend_id(rs.getString("send_id"));
            lostInfoEntity.setCollect_time(rs.getInt("collect_time"));
            lostInfoEntity.setCommit_time(rs.getInt("commit_time"));
            mList.add(lostInfoEntity);
        }

        return mList;

    }

}
