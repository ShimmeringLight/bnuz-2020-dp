package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserMapper
{
    void insert(String userName, String password);

    void deleteByUserName(String userName);

    void deleteById(int id) throws SQLException;

    void updateByEntity(User user) throws SQLException;

    User findById(int id) throws SQLException;

    User findByUserName(String userName);

    List<User> findAll() throws SQLException;
}
