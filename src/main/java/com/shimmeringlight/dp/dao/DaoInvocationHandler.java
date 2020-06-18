package com.shimmeringlight.dp.dao;

import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.service.login.LoginRetention;
import com.shimmeringlight.dp.utils.annotations.Login;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DaoInvocationHandler implements InvocationHandler
{
    Object target;

    Log log = LogFactory.build();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        if (!target.getClass().getAnnotation(Login.class).value())
            return method.invoke(target, args);
        if (!LoginRetention.isLogin())
        {
            log.info("请登录后再执行操作");
            return null;
        }
        return method.invoke(target, args);
    }

    public DaoInvocationHandler(Object target)
    {
        this.target = target;
    }
}
