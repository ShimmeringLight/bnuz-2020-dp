package com.shimmeringlight.dp.log;

/**
 * 日志接口
 */
public interface Log
{
    public LogEntity info(String msg);

    public LogEntity debug(String msg);

    public LogEntity error(String msg);
}
