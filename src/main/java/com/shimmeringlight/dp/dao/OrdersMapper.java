package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.entity.Orders;

import java.util.List;

/**
 * 订单数据访问层接口
 *
 * @see com.shimmeringlight.dp.dao.UserMapper
 */
public interface OrdersMapper
{
    void insertByEntity(Orders orders);

    void deleteById(int id);

    void updateByEntity(Orders orders);

    Orders findById(int id);

    Orders findByEntity(Orders orders);

    List<Orders> findAll();
}
