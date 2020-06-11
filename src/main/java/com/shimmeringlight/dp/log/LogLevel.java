package com.shimmeringlight.dp.log;


import com.shimmeringlight.dp.config.LoadedProperties;

public enum LogLevel
{
    INFO,DEBUG,ERROR;

    public static LogLevel getFromProperties()
    {
        String level = LoadedProperties.getInstance().getProperties().getProperty("log.level");
        if(level.equalsIgnoreCase("INFO"))
            return INFO;
        if(level.equalsIgnoreCase("DEBUG"))
            return DEBUG;
        if(level.equalsIgnoreCase("ERROR"))
            return ERROR;
        return null;
    }
}
