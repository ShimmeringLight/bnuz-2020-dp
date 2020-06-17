package com.shimmeringlight.dp.dao.impl.factory;

import com.shimmeringlight.dp.dao.DaoInvocationHandler;
import com.shimmeringlight.dp.dao.UserMapper;
import com.shimmeringlight.dp.dao.impl.UserMapperImpl;
import com.shimmeringlight.dp.utils.ProxyFactory;

public class DaoFactoryImpl implements DaoFactory
{
    @Override
    public UserMapper buildUserMapper()
    {
        UserMapper userMapper = UserMapperImpl.getInstance();
        return (UserMapper) ProxyFactory.build(userMapper,new DaoInvocationHandler(userMapper));
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
