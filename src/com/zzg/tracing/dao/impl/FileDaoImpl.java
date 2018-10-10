package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.FileDao;
import com.zzg.tracing.entity.FileEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FileDaoImpl implements FileDao {


    /**
     * 保存文件信息
     *
     * @param connection
     * @param mList
     * @return
     */
    @Override
    public boolean saveFile(Connection connection, List<FileEntity> mList) {
        String sql = "insert  into file (file_type,user_id,lost_info_id,file_url,create_time)values (?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < mList.size(); i++) {
                ps.setObject(1, mList.get(i).getFile_type());
                ps.setObject(2, mList.get(i).getUser_id());
                ps.setObject(3, mList.get(i).getLost_info_id());
                ps.setObject(4, mList.get(i).getFile_url());
                ps.setObject(5, mList.get(i).getCreate_time());
            }
            int i = ps.executeUpdate();

            if (i > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
