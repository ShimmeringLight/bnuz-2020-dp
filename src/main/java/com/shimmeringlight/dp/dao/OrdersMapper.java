package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.entity.OrderPo;

import java.util.List;

/**
 * 订单数据访问层接口
 *
 * @see com.shimmeringlight.dp.dao.UserMapper
 */
public interface OrdersMapper
{
    void insertByEntity(OrderPo orderPo);

    void deleteById(int id);

    void updateByEntity(OrderPo orderPo);

    OrderPo findById(int id);

    OrderPo findByEntity(OrderPo orderPo);

    List<OrderPo> findAll();
}
