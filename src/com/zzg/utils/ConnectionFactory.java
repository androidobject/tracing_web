package com.zzg.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 数据库连接工厂类
 */

public class ConnectionFactory {


    private static String driver;
    private static String dburl;
    private static String user;
    private static String passwrod;

    /**
     * 单列模式
     */
    private static final ConnectionFactory factory = new ConnectionFactory();

    /**
     * 获取连接
     */
    private Connection connection;

    private ConnectionFactory() {
    }


    public static ConnectionFactory getInstance() {
        return factory;
    }


    static {
        Properties properties = new Properties();

        try {
            InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println("=====================配置文件读取错误");
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        dburl = properties.getProperty("dburl");
        user = properties.getProperty("user");
        passwrod = properties.getProperty("password");

    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public Connection makeConnection() {
        try {
            //驱动
            Class.forName(driver);
            //获取连接
            connection = DriverManager.getConnection(dburl, user, passwrod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


}
