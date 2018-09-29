package com.zzg.tracing.service;

import com.zzg.tracing.dao.UserDao;
import com.zzg.tracing.dao.impl.UserDaoImpl;
import com.zzg.tracing.entity.UserEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;

/**
 * 登录流程
 */
public class LoginService {

    UserDao dao = new UserDaoImpl();

    /**
     * 登录
     */
    public String login(String username, String password) {

        String msg = "";

        Connection connection = null;

        try {
            connection = ConnectionFactory.getInstance().makeConnection();
            UserEntity userEntity = new UserEntity();
            userEntity.setPhone(username);
            userEntity.setPassword(password);
            boolean login = dao.Login(connection, userEntity);
            if (login) {
                msg = "ok";
            } else {
                msg = "用户名或密码错误";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "未知错误";
        }

        return msg;
    }

    /**
     * 登录成功返回用户信息
     *
     * @param username
     */
    public UserEntity searchUser(String username) {
        Connection connection = null;
        UserEntity entity = null;

        try {
            connection = ConnectionFactory.getInstance().makeConnection();
            entity = dao.search(connection, username);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return entity;
    }
}
