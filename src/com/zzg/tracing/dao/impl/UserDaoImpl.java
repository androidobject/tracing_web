package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.UserDao;
import com.zzg.tracing.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public int rigister(Connection connection, UserEntity userEntity) {
        int num = 0;

        String sql = "INSERT into user (phone,user_name,password,create_time,rigister_by_phone) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userEntity.getPhone());
            ps.setString(2, userEntity.getUser_name());
            ps.setString(3, userEntity.getPassword());
            ps.setString(4, userEntity.getCreate_time());
            ps.setString(5, userEntity.getRigister_by_phone());
            num = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;

    }

    @Override
    public boolean Login(Connection connection, UserEntity userEntity) {
        String sql = "SELECT * from user where phone=? and password =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userEntity.getPhone());
            ps.setString(2, userEntity.getPassword());
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * 检查是否存在
     *
     * @param connection
     * @param phone
     * @return
     */
    @Override
    public boolean check(Connection connection, String phone) {
        String sql = "SELECT * FROM user WHERE phone=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 更新最后登录时间
     */

    @Override
    public UserEntity search(Connection connection, String phone) {
        String sql = "update user set last_login_time=? where phone=?";

        String sql_user = "select * from user where phone=?";

        UserEntity entity = new UserEntity();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getCreate_time());
            ps.setString(2, phone);
            ps.executeUpdate();


            PreparedStatement psearch = connection.prepareStatement(sql_user);
            psearch.setString(1, phone);
            ResultSet resultSet = psearch.executeQuery();

            resultSet.next();
            entity.setId(resultSet.getInt("id"));
            entity.setPhone(resultSet.getString("phone"));
            entity.setUser_name(resultSet.getString("user_name"));
            entity.setPassword(resultSet.getString("password"));
            entity.setPhoto(resultSet.getString("photo"));
            entity.setCreate_time(resultSet.getString("create_time"));
            entity.setLast_login_time(resultSet.getString("last_login_time"));
            entity.setAddress(resultSet.getString("address"));
            entity.setWeixin(resultSet.getString("weixin"));
            entity.setRigister_by_phone(resultSet.getString("rigister_by_phone"));

            return entity;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }


}
