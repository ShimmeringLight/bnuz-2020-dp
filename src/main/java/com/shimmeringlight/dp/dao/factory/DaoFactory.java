package com.shimmeringlight.dp.dao.factory;

import com.shimmeringlight.dp.dao.GoodsListMapper;
import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.OrdersMapper;
import com.shimmeringlight.dp.dao.UserMapper;

public interface DaoFactory
{
    UserMapper buildUserMapper();

    GoodsMapper buildGoodsMapper();

    GoodsListMapper buildGoodsListMapper();

    OrdersMapper buildOrdersMapper();
}
