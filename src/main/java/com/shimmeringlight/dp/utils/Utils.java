package com.shimmeringlight.dp.utils;

import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;

public class Utils
{
    private static final Log log = LogFactory.build();

    private Utils()
    {
    }

    public static void logSQL(String sql)
    {
        log.debug("SQL: " + sql);
    }
}
