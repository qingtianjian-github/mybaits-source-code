package com.jiagouedu.util;

import java.sql.*;

/**
 * @author cjw
 */
public class DBUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * 获取连接的公共方法
     * @return
     */
    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 关闭Connection
     * @param connection
     */
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭Statement
     * @param statement
     */
    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭ResultSet
     * @param resultSet
     */
    public static void closeresultset(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭ResultSet, Statement, Connection
     * @param closeables
     */
    public static void closeAll(AutoCloseable... closeables) {
        for(AutoCloseable autoCloseable : closeables) {
            try {
                if (autoCloseable != null) {
                    autoCloseable.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
