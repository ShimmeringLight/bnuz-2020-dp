package com.shimmeringlight.dp.dao.impl;

import com.shimmeringlight.dp.config.LoadedProperties;
import com.shimmeringlight.dp.dao.UserMapper;
import com.shimmeringlight.dp.entity.User;
import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapperImpl implements UserMapper
{
    final String JDBC_DRIVER;

    final String DB_URL;

    final String USER;

    final String PASSWORD;

    Connection connection;

    Statement statement;

    Log log = LogFactory.build();

    public void insert(String userName, String password) throws SQLException
    {
        statement.executeQuery("use dp");
        String sql = "insert into user (userName,password) values ('" + userName + "','" +
                password + "')";
        log.info("SQL: " + sql);
        statement.executeUpdate(sql);
    }

    public void deleteByUserName(String userName) throws SQLException
    {
        statement.executeQuery("use dp");
        String sql = "delete from user where userName = '" + userName + "'";
        log.info("SQL: " + sql);
        statement.executeUpdate(sql);
    }

    @Override
    public void deleteById(int id) throws SQLException
    {
        statement.executeQuery("use dp");
        String sql = "delete from user where userId = " + id;
        log.info("SQL: " + sql);
        statement.executeUpdate(sql);
    }

    public void updateByEntity(User user) throws SQLException
    {
        String sql = "update user set userName = '" + user.getUserName()
                + "',password = '" + user.getPassword()
                + "' where userId =" + user.getUserId();
        log.info("SQL: " + sql);
        statement.executeUpdate(sql);
    }

    public User findById(int id) throws SQLException
    {
        statement.executeQuery("use dp");
        String sql = "select * from User where dp.User.userId = " + id;
        log.info("SQL: " + sql);
        ResultSet resultSet = statement.executeQuery(sql);
        User user = new User();
        while (resultSet.next())
        {
            user.setUserId(resultSet.getInt("userId"));
            user.setUserName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("password"));
        }
        return user;
    }

    @Override
    public User findByUserName(String userName) throws SQLException
    {
        statement.executeQuery("use dp");
        String sql = "select * from dp.User where userName = '" + userName + "'";
        log.info("SQL: " + sql);
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        return new User(resultSet.getInt("userId"),
                resultSet.getString("userName"),
                resultSet.getString("password"));
    }

    public List<User> findAll() throws SQLException
    {
        String sql = "select * from User";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<User> users = new ArrayList<>();
        while (resultSet.next())
        {
            users.add(new User(resultSet.getInt("userId"),
                    resultSet.getString("userName"),
                    resultSet.getString("password")));
        }
        log.info("Found: " + users.size());
        return users;
    }

    public UserMapperImpl(String JDBC_DRIVER, String DB_URL, String USER, String PASSWORD) throws Exception
    {
        this.JDBC_DRIVER = JDBC_DRIVER;
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        log.info("Loading Driver");
        Class.forName(JDBC_DRIVER);
        log.info("Connecting to database");
        connection = DriverManager.getConnection(DB_URL);
        log.info("Creating statement");
        statement = connection.createStatement();
    }

    public UserMapperImpl() throws Exception
    {
        this.JDBC_DRIVER = LoadedProperties.getInstance().getProperties().getProperty("jdbc.driver");
        this.DB_URL = LoadedProperties.getInstance().getProperties().getProperty("jdbc.url");
        this.USER = LoadedProperties.getInstance().getProperties().getProperty("jdbc.user");
        this.PASSWORD = LoadedProperties.getInstance().getProperties().getProperty("jdbc.password");
        log.info("Loading Driver");
        log.info("Connecting to database");
        connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
        log.info("Creating statement");
        statement = connection.createStatement();
    }
}
