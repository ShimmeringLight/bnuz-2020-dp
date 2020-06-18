package com.shimmeringlight.dp.service.login;

import com.shimmeringlight.dp.dao.UserMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactory;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.User;

public class LoginServiceImpl implements LoginService
{
    DaoFactory daoFactory = DaoFactoryImpl.getInstance();

    UserMapper userMapper = daoFactory.buildUserMapper();

    @Override
    public boolean login(String userName, String password)
    {
        if(LoginRetention.isLogin())
            return true;
        User user = userMapper.findByUserName(userName);
        if(user.getPassword().equals(password))
        {
            LoginRetention.setIsLogin(true);
            return true;
        }
        return false;
    }
}
