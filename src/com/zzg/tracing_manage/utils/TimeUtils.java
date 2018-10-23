package com.zzg.tracing_manage.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 获取当前系统时间
     */

    public static Timestamp getCurrent() {
//        SimpleDateFormat simpleTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义日期格式  默认时间格式：yyyy-MM-dd HH:mm:ss

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;

    }


    public static String getStringTime() {
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        Date date = new Date();
        String time = bf.format(date);
        return time;
    }


}
