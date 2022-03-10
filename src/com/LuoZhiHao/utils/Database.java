package com.LuoZhiHao.utils;

import com.LuoZhiHao.controller.DatabaseController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static int update(String sql) throws SQLException {
        int count = 0;
        connection = DatabaseController.getConnection();
        statement = connection.createStatement();
        count = statement.executeUpdate(sql);
        statement.close();
        connection.close();
        return count;
    }

    public static ResultSet query(String sql) throws SQLException {
        connection = DatabaseController.getConnection();
        statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    //释放所有数据库连接
    public static void releaseAll() throws SQLException {
        if(resultSet != null){
            resultSet.close();
            resultSet = null;
        }
        if (statement != null){
            statement.close();
            statement = null;
        }
        if (connection != null){
            connection.close();
            connection = null;
        }
        System.out.println("已释放所有数据库连接！");
    }
}
