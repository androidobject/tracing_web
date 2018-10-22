package com.zzg.tracing_manage.dao.impl;

import com.zzg.tracing_manage.dao.LoginMDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMDaoImpl implements LoginMDao {


    @Override
    public String loginM(Connection connection, String username, String password) {
        String result = "";
        String sql = "SELECT * from m_user where username=? and password=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                result = "登录成功";
            } else {
                result = "用户名或密码错误！";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            result = "服务器异常，请稍后再试！";

        }


        return result;
    }
}
