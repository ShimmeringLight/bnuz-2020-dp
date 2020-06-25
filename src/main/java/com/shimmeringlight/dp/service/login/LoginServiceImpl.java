package com.shimmeringlight.dp.service.login;

import com.shimmeringlight.dp.dao.UserMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactory;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.User;

/**
 * 登录业务逻辑实现，为单例
 */
public class LoginServiceImpl implements LoginService
{
    DaoFactory daoFactory = DaoFactoryImpl.getInstance();

    UserMapper userMapper = daoFactory.buildUserMapper();

    /**
     * 登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return 是否登录成功
     */
    @Override
    public boolean login(String userName, String password)
    {
        if (LoginRetention.isLogin())
            return true;
        User user = userMapper.findByUserName(userName);
        if (user.getPassword().equals(password))
        {
            LoginRetention.setIsLogin(true);
            return true;
        }
        return false;
    }

    //单例
    private static class Instance
    {
        public static final LoginServiceImpl instance = new LoginServiceImpl();
    }

    public static LoginServiceImpl getInstance()
    {
        return LoginServiceImpl.Instance.instance;
    }
}
