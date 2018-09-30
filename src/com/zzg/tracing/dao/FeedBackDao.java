package com.zzg.tracing.dao;

import com.zzg.tracing.entity.FeedBackEntity;

import java.sql.Connection;

public interface FeedBackDao {

    public boolean feedBack(Connection connection, FeedBackEntity entity);

}
