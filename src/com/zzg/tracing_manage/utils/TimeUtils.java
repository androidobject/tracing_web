package com.zzg.tracing_manage.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 获取当前系统时间
     */

    public static String getCurrent() {
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        Date date = new Date();
        String currentTime = bf.format(date);
        return currentTime;

    }

}
