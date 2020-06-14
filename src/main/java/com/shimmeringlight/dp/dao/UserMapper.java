package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserMapper
{
    void insert(String userName,String password) throws SQLException;

    void deleteByUserName(String userName) throws SQLException;

    void deleteById(int id) throws SQLException;

    void updateByEntity(User user) throws SQLException;

    User findById(int id) throws SQLException;

    User findByUserName(String userName) throws SQLException;

    List<User> findAll() throws SQLException;
}
