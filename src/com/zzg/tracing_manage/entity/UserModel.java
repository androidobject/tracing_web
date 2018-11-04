package com.zzg.tracing_manage.entity;

public class UserModel {
    private int id;
    private String phone;
    private String user_name;
    private String photo;
    private String password;
    private String adress;
    private String weixin;
    private String create_time;
    private String rigister_by_phone;
    private String last_login_time;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getWeixin() {
        return this.weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getRigister_by_phone() {
        return this.rigister_by_phone;
    }

    public void setRigister_by_phone(String rigister_by_phone) {
        this.rigister_by_phone = rigister_by_phone;
    }

    public String getLast_login_time() {
        return this.last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }
}
