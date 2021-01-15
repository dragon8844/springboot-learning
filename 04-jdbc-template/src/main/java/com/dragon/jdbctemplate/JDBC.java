package com.dragon.jdbctemplate;

import java.sql.*;

/**
 * @author lilong
 */
public class JDBC {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";

        //1.通过DriverManager获取connection连接
        Connection connection = DriverManager.getConnection(url, username, password);

        //2.创建preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");

        //3.执行SQL返回ResultSet
        ResultSet resultSet = preparedStatement.executeQuery();

        //4.遍历resultSet结果集
        while (resultSet.next()) {
            //resultSet.getString("1");
        }

        //5.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
