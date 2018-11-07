package com.zzg.tracing.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 丢失人发布信息
 */

public class LostInfoEntity implements Serializable {

    //主键 id
    private int id;
    //发布平台
    private String send_by_phone;
    //发布时间
    private String create_time;
    //查看次数
    private int look_times;
    //发布人id
    private int send_id;
    //收藏次数
    private int collect_times;
    //丢失地区
    private String lost_area;
    //评论数
    private int commit_times;
    //丢失人信息
    private LostPeopleEntity lostPeople;
    //发布用户信息
    private UserEntity userEntity;

    public String getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLost_area() {
        return this.lost_area;
    }

    public void setLost_area(String lost_area) {
        this.lost_area = lost_area;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSend_by_phone() {
        return this.send_by_phone;
    }

    public void setSend_by_phone(String send_by_phone) {
        this.send_by_phone = send_by_phone;
    }

    public int getLook_times() {
        return this.look_times;
    }

    public void setLook_times(int look_times) {
        this.look_times = look_times;
    }

    public int getSend_id() {
        return this.send_id;
    }

    public void setSend_id(int send_id) {
        this.send_id = send_id;
    }

    public int getCollect_times() {
        return this.collect_times;
    }

    public void setCollect_times(int collect_times) {
        this.collect_times = collect_times;
    }

    public int getCommit_times() {
        return this.commit_times;
    }

    public void setCommit_times(int commit_times) {
        this.commit_times = commit_times;
    }

    public LostPeopleEntity getLostPeople() {
        return this.lostPeople;
    }

    public void setLostPeople(LostPeopleEntity lostPeople) {
        this.lostPeople = lostPeople;
    }

    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
