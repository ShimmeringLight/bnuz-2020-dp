package com.shimmeringlight.dp.dao.impl;

import com.shimmeringlight.dp.utils.Utils;
import com.shimmeringlight.dp.utils.annotations.Login;
import com.shimmeringlight.dp.utils.config.LoadedProperties;
import com.shimmeringlight.dp.dao.UserMapper;
import com.shimmeringlight.dp.entity.User;
import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//单例
@Login(value = false)
public class UserMapperImpl implements UserMapper
{
    final String JDBC_DRIVER;

    final String DB_URL;

    final String USER;

    final String PASSWORD;

    Connection connection;

    Statement statement;

    Log log = LogFactory.build();

    private static class Instance
    {
        public static final UserMapperImpl instance = new UserMapperImpl();
    }

    public static UserMapperImpl getInstance()
    {
        return UserMapperImpl.Instance.instance;
    }

    public void insert(String userName, String password)
    {
        try
        {
            statement.executeQuery("use dp");
            String sql = "insert into user (userName,password) values ('" + userName + "','" +
                    password + "')";
            Utils.logSQL(sql);
            statement.executeUpdate(sql);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void deleteByUserName(String userName)
    {
        try
        {
            statement.executeQuery("use dp");
            String sql = "delete from user where userName = '" + userName + "'";
            Utils.logSQL(sql);
            statement.executeUpdate(sql);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) throws SQLException
    {
        statement.executeQuery("use dp");
        String sql = "delete from user where userId = " + id;
        Utils.logSQL(sql);
        statement.executeUpdate(sql);
    }

    public void updateByEntity(User user) throws SQLException
    {
        String sql = "update user set userName = '" + user.getUserName()
                + "',password = '" + user.getPassword()
                + "' where userId =" + user.getUserId();
        Utils.logSQL(sql);
        statement.executeUpdate(sql);
    }

    public User findById(int id) throws SQLException
    {
        statement.executeQuery("use dp");
        String sql = "select * from User where dp.User.userId = " + id;
        Utils.logSQL(sql);
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
    public User findByUserName(String userName)
    {
        try
        {
            statement.executeQuery("use dp");
            String sql = "select * from dp.User where userName = '" + userName + "'";
            Utils.logSQL(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            return new User(resultSet.getInt("userId"),
                    resultSet.getString("userName"),
                    resultSet.getString("password"));
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<User> findAll() throws SQLException
    {
        String sql = "select * from User";
        Utils.logSQL(sql);
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

    private UserMapperImpl()
    {
        log.debug("Loading UserMapper");
        this.JDBC_DRIVER = LoadedProperties.getInstance().getProperties().getProperty("jdbc.driver");
        this.DB_URL = LoadedProperties.getInstance().getProperties().getProperty("jdbc.url");
        this.USER = LoadedProperties.getInstance().getProperties().getProperty("jdbc.user");
        this.PASSWORD = LoadedProperties.getInstance().getProperties().getProperty("jdbc.password");
        log.debug("Loading Driver");
        log.debug("Connecting to database");
        try
        {
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        log.info("Creating statement");
        try
        {
            statement = connection.createStatement();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
