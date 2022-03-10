package com.LuoZhiHao.controller;

import java.sql.*;

public class DatabaseController {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/tv?characterEncoding=utf8&useSSL=false&serverTimezone = GMT";
    private static String username = "root";
    private static String password = "Qwe111..";
    private static Connection connection = null;

    //获取数据库连接：Connection con = DatabaseController.getConnection;
    public static Connection getConnection(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接错误！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库连接驱动未找到！");
        }
        return connection;
    }


    public static void main(String[] args)  {
        //测试数据库连接是否成功
        Connection con = DatabaseController.getConnection();
        System.out.println("数据库连接成功");
    }
}
