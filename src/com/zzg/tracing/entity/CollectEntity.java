package com.zzg.tracing.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CollectEntity implements Serializable {

    //丢失信息id
    private int lost_info_id;
    //收藏时间
    private String collect_time;
    //收藏途径
    private String collect_by_phone;
    //收藏人id
    private int collect_user_id;


    public CollectEntity() {
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        Date date = new Date();
        collect_time = bf.format(date);
    }


    public int getLost_info_id() {
        return lost_info_id;
    }

    public void setLost_info_id(int lost_info_id) {
        this.lost_info_id = lost_info_id;
    }

    public String getCollect_time() {
        return collect_time;
    }

    public void setCollect_time(String collect_time) {
        this.collect_time = collect_time;
    }

    public String getCollect_by_phone() {
        return collect_by_phone;
    }

    public void setCollect_by_phone(String collect_by_phone) {
        this.collect_by_phone = collect_by_phone;
    }

    public int getCollect_user_id() {
        return collect_user_id;
    }

    public void setCollect_user_id(int collect_user_id) {
        this.collect_user_id = collect_user_id;
    }
}
