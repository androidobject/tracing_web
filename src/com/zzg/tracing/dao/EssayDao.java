package com.zzg.tracing.dao;

import com.zzg.tracing.entity.EssayEntity;

import java.sql.Connection;
import java.util.List;

public interface EssayDao {

    public List<EssayEntity> getEssay(Connection connection,int num);

}
