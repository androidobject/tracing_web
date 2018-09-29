package com.zzg.tracing.service;

import com.zzg.tracing.dao.UserDao;
import com.zzg.tracing.dao.impl.UserDaoImpl;
import com.zzg.tracing.entity.UserEntity;
import com.zzg.tracing.utils.ConnectionFactory;

import java.sql.Connection;

/**
 * 注册账号
 */
public class RigisterService {
    private UserDao dao = new UserDaoImpl();


    /**
     * 注册
     *
     * @param
     * @return
     */
    public String rigister(String phone, String passwrod, String rigister_by_phone) {

        String msg = "";

        Connection connection = null;
        try {
            connection = ConnectionFactory.getInstance().makeConnection();
//            connection.setAutoCommit(false);
            boolean check = dao.check(connection, phone);
            if (check) {
                msg = "用户已经注册！";
                return msg;
            } else {
                UserEntity userEntity = new UserEntity();
                userEntity.setPhone(phone);
                userEntity.setUser_name(phone);
                userEntity.setPassword(passwrod);
                userEntity.setRigister_by_phone(rigister_by_phone);
                int rigister = dao.rigister(connection, userEntity);
                if (rigister == 0) {
                    msg = "注册失败";
                } else {
                    msg = "ok";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;

    }


}
