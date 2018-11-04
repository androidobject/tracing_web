package com.zzg.tracing_manage.dao.impl;

import com.zzg.tracing_manage.dao.UserDao;
import com.zzg.tracing_manage.entity.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<UserModel> userList(Connection connection) {
        List<UserModel> mList = new ArrayList<>();

        String sql = "select * from user order by id desc ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserModel model = new UserModel();
                model.setId(rs.getInt("id"));
                model.setPhone(rs.getString("phone"));
                model.setUser_name(rs.getString("user_name"));
                model.setPassword(rs.getString("password"));
                model.setPhoto(rs.getString("photo"));
                model.setAdress(rs.getString("address"));
                model.setWeixin(rs.getString("weixin"));
                model.setCreate_time(rs.getString("create_time"));
                model.setRigister_by_phone(rs.getString("rigister_by_phone"));
                model.setLast_login_time(rs.getString("last_login_time"));
                mList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mList;
    }

    @Override
    public boolean checkAdmin(Connection connection, String mUser) {

        String sql = "select * from admin_user where uid=?";
        boolean isHave = false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            int uid = Integer.parseInt(mUser);
            ps.setInt(1, uid);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                isHave = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return isHave;
    }
}
