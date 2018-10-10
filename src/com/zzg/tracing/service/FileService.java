package com.zzg.tracing.service;

import com.zzg.tracing.dao.FileDao;
import com.zzg.tracing.dao.impl.FileDaoImpl;
import com.zzg.tracing.entity.FileEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public class FileService {

    private FileDao dao = new FileDaoImpl();

    /**
     * 保存文件到数据库
     *
     * @param mlist
     * @return
     */
    public boolean saveFileToSql(List<FileEntity> mlist) {
        Connection connection = ConnectionFactory.getInstance().makeConnection();
        boolean b = dao.saveFile(connection, mlist);
        return b;
    }


}
