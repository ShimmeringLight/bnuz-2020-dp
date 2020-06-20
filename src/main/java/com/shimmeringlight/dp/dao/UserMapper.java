package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户数据访问层接口
 */
public interface UserMapper
{
    /**
     * 插入记录
     *
     * @param userName 用户名
     * @param password 密码
     */
    void insert(String userName, String password);

    /**
     * 根据用户名删除记录
     *
     * @param userName 用户名
     */
    void deleteByUserName(String userName);

    /**
     * 根据id删除
     *
     * @param id id
     */
    void deleteById(int id) throws SQLException;

    /**
     * 根据实体类更新
     *
     * @param user 用户实体类
     */
    void updateByEntity(User user);

    /**
     * 根据id查询
     *
     * @param id id
     * @return 结果集映射的实体类
     */
    User findById(int id);

    /**
     * 根据用户名查询
     *
     * @param userName 用户名
     * @return 结果集映射的实体类
     */
    User findByUserName(String userName);

    /**
     * 查询所有记录
     *
     * @return 结果集映射的实体类
     */
    List<User> findAll();
}
