package com.zzg.tracing.dao;

import com.zzg.tracing.entity.UserEntity;

import java.sql.Connection;

public interface UserDao {

    /**
     * 注册
     *
     * @param connection
     * @param userEntity
     */
    public int rigister(Connection connection, UserEntity userEntity);

    /**
     * 登录
     *
     * @param connection
     * @param userEntity
     */

    public void Login(Connection connection, UserEntity userEntity);

    /**
     * 检查是否存在
     */
    public boolean check(Connection connection, String phone);


}
