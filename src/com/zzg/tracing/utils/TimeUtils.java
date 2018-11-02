package com.zzg.tracing.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {


    /**
     * 获取格式化的当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        Date date = new Date();
        String currentTime = bf.format(date);

        return currentTime;
    }

}
