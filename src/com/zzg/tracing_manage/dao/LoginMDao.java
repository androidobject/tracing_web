package com.zzg.tracing_manage.dao;

import java.sql.Connection;

/**
 * 管理后台登录
 */
public interface LoginMDao {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    String loginM(Connection connection,String username, String password);

}
