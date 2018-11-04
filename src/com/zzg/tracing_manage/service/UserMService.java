package com.zzg.tracing_manage.service;

import com.zzg.tracing.utils.ConnectionFactory;
import com.zzg.tracing_manage.dao.UserDao;
import com.zzg.tracing_manage.dao.impl.UserDaoImpl;
import com.zzg.tracing_manage.entity.UserModel;

import java.sql.Connection;
import java.util.List;

public class UserMService {

    private UserDao dao = new UserDaoImpl();


    public List<UserModel> getUserList() {
        Connection connection = ConnectionFactory.getInstance().makeConnection();
        List<UserModel> mlist = dao.userList(connection);
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


}
