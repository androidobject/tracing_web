package com.zzg.tracing.utils;

public class TextUtils {

    /**
     * 判断是否为null
     * @param o
     * @return
     */
    public static boolean isEmpty(String o) {

        if (o == null || "".equals(o)) {
            return true;
        }
        return false;

    }

}
