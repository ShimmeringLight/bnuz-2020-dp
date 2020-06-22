package com.shimmeringlight.dp.dao.handler;

import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.service.login.LoginRetention;
import com.shimmeringlight.dp.utils.annotations.Login;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 数据访问对象的InvocationHandler，用于处理登陆
 */
public class DaoInvocationHandler implements InvocationHandler
{
    //代理目标
    Object target;

    Log log = LogFactory.build();

    /**
     * 检查登录注解是否存在，若存在且要求登陆，则执行登录验证
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        if(!method.getClass().isAnnotationPresent(Login.class))
            return method.invoke(target,args);
        else if (method.getClass().getAnnotation(Login.class).value() && !LoginRetention.isLogin())
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
