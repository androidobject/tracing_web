package com.zzg.tracing.dao.impl;

import com.zzg.tracing.dao.UserDao;
import com.zzg.tracing.entity.UserEntity;
import com.zzg.tracing.utils.TimeUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            ps.setString(4, TimeUtils.getCurrentTime());
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
     * 检查uid是否存在
     *
     * @param connection
     * @param id
     * @return
     */
    @Override
    public boolean checkUID(Connection connection, String id) {

        String sql = "SELECT * FROM user WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
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
            ps.setString(1, TimeUtils.getCurrentTime());
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

    /**
     * 列举用户列表
     *
     * @param connection
     * @return
     */
    @Override
    public List<UserEntity> userList(Connection connection) {
        List<UserEntity> mList = new ArrayList<>();

        String sql = "select * from user order by id desc ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserEntity model = new UserEntity();
                model.setId(rs.getInt("id"));
                model.setPhone(rs.getString("phone"));
                model.setUser_name(rs.getString("user_name"));
                model.setPassword(rs.getString("password"));
                model.setPhoto(rs.getString("photo"));
                model.setAddress(rs.getString("address"));
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

    /**
     * 检查管理员是否存在
     *
     * @param connection
     * @param mUser
     * @return
     */
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


    /**
     * 管理后台登录
     *
     * @param connection
     * @param username
     * @param password
     * @return
     */
    @Override
    public String loginM(Connection connection, String username, String password) {
        String result = "";
        String sql = "SELECT * from admin_user where username=? and password=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                result = "登录成功";
                //更新登录时间
                String sql_time = "update admin_user set last_login=? where username=?";
                PreparedStatement pst = connection.prepareStatement(sql_time);
                pst.setString(1, TimeUtils.getCurrentTime());
                pst.setString(2, username);
                pst.executeUpdate();
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
