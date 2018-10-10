package com.zzg.tracing.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件实体
 */
public class FileEntity implements Serializable {
    public FileEntity() {
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        Date date = new Date();
        create_time = bf.format(date);
    }

    //文件类型 、1 用户信息发布
    private String file_type;
    //用户id
    private int user_id;
    //丢失信息id
    private int lost_info_id;
    //非绝对路径
    private String file_url;
    //创建时间
    private String create_time;

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLost_info_id() {
        return lost_info_id;
    }

    public void setLost_info_id(int lost_info_id) {
        this.lost_info_id = lost_info_id;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
