package com.shimmeringlight.dp.main.log;

import com.shimmeringlight.dp.main.utils.ProxyFactory;

public class LogFactory
{
    public static Log build()
    {
        Log log = new LogEntity();
        LogFitter fitter = new LogFitter(log);
        return (Log) ProxyFactory.build(log,fitter);
    }
}
