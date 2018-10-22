package com.zzg.tracing_manage.service;

import com.zzg.tracing.utils.ConnectionFactory;
import com.zzg.tracing_manage.dao.LoginMDao;
import com.zzg.tracing_manage.dao.impl.LoginMDaoImpl;

import java.sql.Connection;

public class LoginMService {

    LoginMDao dao = new LoginMDaoImpl();

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
