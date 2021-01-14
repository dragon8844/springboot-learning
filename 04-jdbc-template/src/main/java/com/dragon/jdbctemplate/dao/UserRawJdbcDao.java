package com.dragon.jdbctemplate.dao;

import com.dragon.jdbctemplate.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;


/**
 *  原生JDBC
 * @author lilong
 */
@Repository
public class UserRawJdbcDao implements UserDao{

    @Resource
    private DataSource dataSource;

    final String SQL_INSERT = "INSERT INTO user(username, password, create_time) VALUES(?, ?, ?)";
    final String SQL_SELECT_ID = "SELECT id,username,password,create_time FROM user WHERE id = ?";
    final String SQL_SELECT_USERNAME = "SELECT id,username,password,create_time FROM user WHERE username = ?";
    final String SQL_UPDATE = "UPDATE user SET username = ?, password = ? WHERE id = ?";
    final String SQL_DELETE = "DELETE FROM user WHERE id = ?";


    @Override
    public Integer insert(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Integer count = 0;

        try{
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setTimestamp(3,new Timestamp(user.getCreateTime().getTime()));
            count = statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return count;
    }

    @Override
    public User selectById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        User user = null;
        try{
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setCreateTime(rs.getTimestamp("create_time"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public User selectByUsername(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        User user = null;
        try{
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_USERNAME);
            statement.setString(1, username);
            rs = statement.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setCreateTime(rs.getTimestamp("create_time"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public Integer updateById(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Integer count = 0;

        try{
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getId());
            count = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return count;
    }

    @Override
    public Integer deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Integer count = 0;

        try{
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1,id);
            count = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return count;
    }
}
