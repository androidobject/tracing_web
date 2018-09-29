package com.zzg.tracing.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseResponse implements Serializable {

    public BaseResponse() {
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        Date date = new Date();
        time = bf.format(date);
    }

    //0失败、1成功
    private int status = 0;

    private String message;

    private Object data;

    private String time;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
