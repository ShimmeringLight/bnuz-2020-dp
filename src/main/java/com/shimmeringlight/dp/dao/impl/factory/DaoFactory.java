package com.shimmeringlight.dp.dao.impl.factory;

import com.shimmeringlight.dp.dao.UserMapper;

public interface DaoFactory
{
    UserMapper buildUserMapper();
}
