package com.zzg.tracing.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 丢失人发布信息
 */

public class LostInfoEntity implements Serializable {

    public LostInfoEntity() {

        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        Date date = new Date();
        create_time = bf.format(date);

    }


    //丢失人姓名
    private String lost_name;
    //年龄
    private String lost_age;
    //性别
    private String lost_sex;
    //丢失时身高
    private String lost_high;
    //最后见面时间
    private String last_see_time;
    //丢失时地区
    private String lost_area;
    //发布时间
    private String create_time;
    //联系人姓名
    private String contact_name;
    //联系人电话
    private String contact_phone;
    //联系人微信
    private String contact_wx;
    //联系人地址
    private String contact_address;
    //发布平台
    private String send_by_phone;
    //查看次数
    private int look_time;
    //发布人id
    private String send_id;


    public String getSend_id() {
        return send_id;
    }

    public void setSend_id(String send_id) {
        this.send_id = send_id;
    }

    public String getLost_name() {
        return lost_name;
    }

    public void setLost_name(String lost_name) {
        this.lost_name = lost_name;
    }

    public String getLost_age() {
        return lost_age;
    }

    public void setLost_age(String lost_age) {
        this.lost_age = lost_age;
    }

    public String getLost_sex() {
        return lost_sex;
    }

    public void setLost_sex(String lost_sex) {
        this.lost_sex = lost_sex;
    }

    public String getLost_high() {
        return lost_high;
    }

    public void setLost_high(String lost_high) {
        this.lost_high = lost_high;
    }

    public String getLast_see_time() {
        return last_see_time;
    }

    public void setLast_see_time(String last_see_time) {
        this.last_see_time = last_see_time;
    }

    public String getLost_area() {
        return lost_area;
    }

    public void setLost_area(String lost_area) {
        this.lost_area = lost_area;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_wx() {
        return contact_wx;
    }

    public void setContact_wx(String contact_wx) {
        this.contact_wx = contact_wx;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

    public String getSend_by_phone() {
        return send_by_phone;
    }

    public void setSend_by_phone(String send_by_phone) {
        this.send_by_phone = send_by_phone;
    }

    public int getLook_time() {
        return look_time;
    }

    public void setLook_time(int look_time) {
        this.look_time = look_time;
    }
}
