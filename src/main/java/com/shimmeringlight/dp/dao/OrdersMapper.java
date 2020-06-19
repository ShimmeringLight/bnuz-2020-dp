package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.entity.Orders;

import java.util.List;

public interface OrdersMapper
{
    void insertByEntity(Orders orders);

    void deleteById(int id);

    void updateByEntity(Orders orders);

    Orders findById(int id);

    Orders findByEntity(Orders orders);

    List<Orders> findAll();
}
