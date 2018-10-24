package com.zzg.tracing.entity;

import java.io.Serializable;

/**
 * 丢失人信息
 */

public class LostPeopleEntity implements Serializable {
    private int id;

    //姓名
    private String name;
    //丢失时间
    private String lost_time;
    //丢失描述
    private String lost_des;
    //丢失地区
    private String lost_area;
    //丢失身高
    private String lost_high;
    //图片集合
    private String pic_file;
    //丢失体重
    private String lost_weight;
    //发布id
    private int lost_info_id;
    //创建时间
    private String create_time;
    //创建用户id
    private int create_by_user;
    //别名
    private String nickname;
    //丢失年龄
    private String lost_age;
    //性别
    private String lost_sex;
    //头像
    private String photo;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLost_time() {
        return this.lost_time;
    }

    public void setLost_time(String lost_time) {
        this.lost_time = lost_time;
    }

    public String getLost_des() {
        return this.lost_des;
    }

    public void setLost_des(String lost_des) {
        this.lost_des = lost_des;
    }

    public String getLost_area() {
        return this.lost_area;
    }

    public void setLost_area(String lost_area) {
        this.lost_area = lost_area;
    }

    public String getLost_high() {
        return this.lost_high;
    }

    public void setLost_high(String lost_high) {
        this.lost_high = lost_high;
    }

    public String getPic_file() {
        return this.pic_file;
    }

    public void setPic_file(String pic_file) {
        this.pic_file = pic_file;
    }

    public String getLost_weight() {
        return this.lost_weight;
    }

    public void setLost_weight(String lost_weight) {
        this.lost_weight = lost_weight;
    }

    public int getLost_info_id() {
        return this.lost_info_id;
    }

    public void setLost_info_id(int lost_info_id) {
        this.lost_info_id = lost_info_id;
    }

    public String getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getCreate_by_user() {
        return this.create_by_user;
    }

    public void setCreate_by_user(int create_by_user) {
        this.create_by_user = create_by_user;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLost_age() {
        return this.lost_age;
    }

    public void setLost_age(String lost_age) {
        this.lost_age = lost_age;
    }

    public String getLost_sex() {
        return this.lost_sex;
    }

    public void setLost_sex(String lost_sex) {
        this.lost_sex = lost_sex;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
