package com.shimmeringlight.dp.dao.factory;

import com.shimmeringlight.dp.dao.DaoInvocationHandler;
import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.UserMapper;
import com.shimmeringlight.dp.dao.impl.GoodsMapperImpl;
import com.shimmeringlight.dp.dao.impl.UserMapperImpl;
import com.shimmeringlight.dp.utils.ProxyFactory;

public class DaoFactoryImpl implements DaoFactory
{
    @Override
    public UserMapper buildUserMapper()
    {
        UserMapper userMapper = UserMapperImpl.getInstance();
        return (UserMapper) ProxyFactory.build(userMapper, new DaoInvocationHandler(userMapper));
    }

    @Override
    public GoodsMapper buildGoodsMapper()
    {
        GoodsMapper goodsMapper = GoodsMapperImpl.getInstance();
        return (GoodsMapper) ProxyFactory.build(goodsMapper, new DaoInvocationHandler(goodsMapper));
    }

    private DaoFactoryImpl()
    {

    }

    private static class Instance
    {
        public static final DaoFactoryImpl instance = new DaoFactoryImpl();
    }

    public static DaoFactoryImpl getInstance()
    {
        return Instance.instance;
    }
}
