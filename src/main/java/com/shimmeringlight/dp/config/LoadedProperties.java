package com.shimmeringlight.dp.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadedProperties
{
    private final Properties properties;

    private LoadedProperties()
    {
        properties = new Properties();
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("src/main/resources/application.properties");
            properties.load(fis);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //单例
    private static class Instance
    {
        public static final LoadedProperties instance = new LoadedProperties();
    }

    public static LoadedProperties getInstance()
    {
        return Instance.instance;
    }

    public Properties getProperties()
    {
        return properties;
    }

}
