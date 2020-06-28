package com.shimmeringlight.dp.utils;

import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;

import java.util.Map;

/**
 * 工具类
 */
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

    public static void printlnFunction(int code, String name)
    {
        System.out.println("【" + code + "】" + name);
    }

    public static void printFunction(Map<Integer,String> param)
    {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Integer,String> e:param.entrySet())
        {
            builder.append("【").append(e.getKey()).append("】").append(e.getValue()).append(" ");
        }
        System.out.println(builder);
    }
}
