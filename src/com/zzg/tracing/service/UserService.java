package com.zzg.tracing.service;

import com.zzg.tracing.dao.UserDao;
import com.zzg.tracing.dao.impl.UserDaoImpl;
import com.zzg.tracing.entity.UserEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public class UserService {
    private UserDao dao = new UserDaoImpl();


    /**
     * 检查用户账号 是否正常
     *
     * @param id
     * @return
     */
    public boolean checkUID(String id) {

        try {
            Connection connection = ConnectionFactory.getInstance().makeConnection();
            boolean b = dao.checkUID(connection, id);

            return b;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }


    public List<UserEntity> getUserList() {
        Connection connection = ConnectionFactory.getInstance().makeConnection();
        List<UserEntity> mlist = dao.userList(connection);
        return mlist;
    }


    /**
     * 检查管理用户是否存在
     *
     * @param user
     * @return
     */
    public boolean checkAdmin(String user) {

        Connection connection = ConnectionFactory.getInstance().makeConnection();
        boolean res = dao.checkAdmin(connection, user);
        return res;
    }



    /**
     * 登录管理后台
     *
     * @return
     */
    public String loginM(String username, String passwrod) {

        Connection connection = ConnectionFactory.getInstance().makeConnection();

        String result = dao.loginM(connection, username, passwrod);

        return result;
    }



}
