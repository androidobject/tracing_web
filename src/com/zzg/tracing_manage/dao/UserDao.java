package com.zzg.tracing_manage.dao;

import com.zzg.tracing_manage.entity.UserModel;

import java.sql.Connection;
import java.util.List;

public interface UserDao {

    /**
     * 获取用户列表
     *
     * @return
     */
    List<UserModel> userList(Connection connection);


    /**
     * 检查管理用户是否存在
     */


    boolean checkAdmin(Connection connection,String mUser);


}
