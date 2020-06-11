package com.shimmeringlight.dp.test;

import com.shimmeringlight.dp.main.log.Log;
import com.shimmeringlight.dp.main.log.LogFactory;

public class LogTest
{
    public static void main(String[] args)
    {
        Log log = LogFactory.build();
        log.info("Test INFO");
        log.debug("Test DEBUG");
        log.error("Test ERROR");
    }
}
