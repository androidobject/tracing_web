package com.zzg.tracing.entity;

import java.io.Serializable;

/**
 * 文章列表
 */
public class EssayEntity implements Serializable {

    private int id;
    private String title;
    private String content;
    private String create_time;
    private String essay_url;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getEssay_url() {
        return essay_url;
    }

    public void setEssay_url(String essay_url) {
        this.essay_url = essay_url;
    }
}
