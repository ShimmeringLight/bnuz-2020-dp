package com.shimmeringlight.dp.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class LogFitter implements InvocationHandler
{
    Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        LogLevel level = LogLevel.getFromProperties();
        LogEntity logEntity = (LogEntity)method.invoke(target,args);
        switch (Objects.requireNonNull(level))
        {
            case INFO:
                if(logEntity.getLevel().equals(LogLevel.INFO) || logEntity.getLevel().equals(LogLevel.ERROR))
                    System.out.println(logEntity.toString());;
                break;
            case ERROR:
                if(logEntity.getLevel().equals(LogLevel.ERROR))
                    System.out.println(logEntity.toString());;
                break;
            case DEBUG:
                System.out.println(logEntity.toString());;
        }
        return logEntity;
    }

    public LogFitter(Log target)
    {
        this.target = target;
    }
}
