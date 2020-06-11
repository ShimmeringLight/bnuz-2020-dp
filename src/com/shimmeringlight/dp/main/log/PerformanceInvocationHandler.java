package com.shimmeringlight.dp.main.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceInvocationHandler implements InvocationHandler
{
    Object target;

    //可以考虑使用多层包装的方式
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        long timeBefore = 0;
        long timeAfter = 0;
        timeBefore = System.currentTimeMillis();
        Object result = method.invoke(target,args);
        timeAfter = System.currentTimeMillis();
        String afterStr = "[Performance]" + "[" + Thread.currentThread().getName() + "]" + method.getName() + " completed in " + (timeAfter - timeBefore) + " ms";
        System.out.println(afterStr);
        return result;
    }

    public PerformanceInvocationHandler(Object target)
    {
        this.target = target;
    }
}
