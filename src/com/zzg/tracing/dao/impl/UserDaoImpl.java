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
    public void Login(Connection connection, UserEntity userEntity) {


    }

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


}
