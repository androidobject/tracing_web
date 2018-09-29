package com.zzg.tracing.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户表
 */

public class UserEntity implements Serializable {

    public UserEntity(){
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        Date date = new Date();
        create_time = bf.format(date);
    }

    private int id;
    private String phone;
    private String user_name;
    private String password;
    private String photo;
    private String address;
    private String weixin;
    private String create_time;
    private String rigister_by_phone;

    private String last_login_time;

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getRigister_by_phone() {
        return rigister_by_phone;
    }

    public void setRigister_by_phone(String rigister_by_phone) {
        this.rigister_by_phone = rigister_by_phone;
    }
}
