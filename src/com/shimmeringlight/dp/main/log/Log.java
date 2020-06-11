package com.shimmeringlight.dp.main.log;

public interface Log
{
    public LogEntity info(String msg);

    public LogEntity debug(String msg);

    public LogEntity error(String msg);
}
