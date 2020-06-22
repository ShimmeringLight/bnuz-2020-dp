package com.shimmeringlight.dp.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 */
public class ProxyFactory
{
    public static Object build(Object target, InvocationHandler handler)
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
