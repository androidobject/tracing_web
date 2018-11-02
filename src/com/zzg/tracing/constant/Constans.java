package com.zzg.tracing.constant;

public class Constans {

    /**
     * false  开发环境 配置、true 生产环境
     * <p>
     * 发布需要改成生产环境
     */
    public static final boolean ISPRODUCTION = false;

    /**
     * 生产
     */
    public static final String HOST_P = "http://47.94.208.5/";
    /**
     * 测试
     */
    public static final String HOST_T = "http://localhost:8080/";


    public static String realPath(String path) {

        if (ISPRODUCTION) {
            return HOST_P + path;
        } else {
            return HOST_T + path;
        }

    }


    /**
     * 获取存储路径
     *
     * @return
     */
    public static String getPath() {
        String path;
        if (ISPRODUCTION) {
            path = "/root/file_upload";
        } else {
            path = "D:\\file_upload";
        }
        return path;
    }
}
