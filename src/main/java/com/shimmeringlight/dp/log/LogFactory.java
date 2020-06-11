package com.shimmeringlight.dp.log;

import com.shimmeringlight.dp.utils.ProxyFactory;

public class LogFactory
{
    public static Log build()
    {
        Log log = new LogEntity();
        LogFitter fitter = new LogFitter(log);
        return (Log) ProxyFactory.build(log,fitter);
    }
}
