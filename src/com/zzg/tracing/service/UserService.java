package com.zzg.tracing.service;

import com.zzg.tracing.dao.UserDao;
import com.zzg.tracing.dao.impl.UserDaoImpl;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;

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


}
