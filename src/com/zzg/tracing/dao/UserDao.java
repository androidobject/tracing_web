package com.zzg.tracing.dao;

import com.zzg.tracing.entity.UserEntity;

import java.sql.Connection;
import java.util.List;

public interface UserDao {

    /**
     * 注册
     *
     * @param connection
     * @param userEntity
     */
    int rigister(Connection connection, UserEntity userEntity);

    /**
     * 登录
     *
     * @param connection
     * @param userEntity
     */

    boolean Login(Connection connection, UserEntity userEntity);

    /**
     * 检查是否存在
     */
    boolean check(Connection connection, String phone);

    /**
     * 检查用户id是否存在
     */
    boolean checkUID(Connection connection, String id);

    /**
     * 查询用户最后登录时间 返回用户信息
     */

    UserEntity search(Connection connection, String phone);


    /**
     * 获取用户列表
     *
     * @return
     */
    List<UserEntity> userList(Connection connection);


    /**
     * 检查管理用户是否存在
     */

    boolean checkAdmin(Connection connection, String mUser);


    /**
     * 管理后台登录
     *
     * @param username
     * @param password
     * @return
     */
    String loginM(Connection connection, String username, String password);

}
