package com.shimmeringlight.dp.dao.factory;

import com.shimmeringlight.dp.dao.GoodsListMapper;
import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.OrdersMapper;
import com.shimmeringlight.dp.dao.UserMapper;

/**
 * 数据访问层抽象工厂接口，生产数据访问对象
 */
public interface DaoFactory
{
    UserMapper buildUserMapper();

    GoodsMapper buildGoodsMapper();

    GoodsListMapper buildGoodsListMapper();

    OrdersMapper buildOrdersMapper();
}
