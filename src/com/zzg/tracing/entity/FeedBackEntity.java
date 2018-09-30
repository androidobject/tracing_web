package com.zzg.tracing.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 意见反馈
 */

public class FeedBackEntity implements Serializable {

    public FeedBackEntity() {
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        Date date = new Date();
        create_time = bf.format(date);
    }


    private String create_time;
    private String content;
    private String contact;
    private String feedback_by_phone;

    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFeedback_by_phone() {
        return feedback_by_phone;
    }

    public void setFeedback_by_phone(String feedback_by_phone) {
        this.feedback_by_phone = feedback_by_phone;
    }
}
