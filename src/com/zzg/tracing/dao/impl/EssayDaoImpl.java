package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.EssayDao;
import com.zzg.tracing.entity.EssayEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EssayDaoImpl implements EssayDao {


    /**
     * 查询文章列表
     *
     * @param connection
     * @param num
     * @return
     */
    @Override
    public List<EssayEntity> getEssay(Connection connection, int num) {
        String sql = "SELECT * FROM essay ORDER BY id DESC LIMIT 0,?; ";
        List<EssayEntity> mList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                EssayEntity essayEntity = new EssayEntity();
                essayEntity.setId(resultSet.getInt("id"));
                essayEntity.setTitle(resultSet.getString("title"));
                essayEntity.setContent(resultSet.getString("content"));
                essayEntity.setCreate_time(resultSet.getString("create_time"));
                essayEntity.setEssay_url(resultSet.getString("essay_url"));
                mList.add(essayEntity);
            }

            return mList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mList;
    }
}
