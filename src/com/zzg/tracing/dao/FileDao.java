package com.zzg.tracing.dao;

import com.zzg.tracing.entity.FileEntity;

import java.sql.Connection;
import java.util.List;

public interface FileDao {

    public boolean  saveFile(Connection connection, List<FileEntity> fileEntity);

}
