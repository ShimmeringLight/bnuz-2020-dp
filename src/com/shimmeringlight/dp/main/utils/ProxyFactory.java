package com.shimmeringlight.dp.main.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory
{
    public static Object build(Object target,InvocationHandler handler)
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),handler);
    }
}
