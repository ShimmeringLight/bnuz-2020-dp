package com.shimmeringlight.dp.log;

public class LogEntity implements Log
{
    private final String content;
    private final String threadName = Thread.currentThread().getName();
    private final LogLevel level;

    public LogEntity(LogLevel level, String content)
    {
        this.level = level;
        this.content = content;
    }

    public LogEntity()
    {
        content = "Initial log content";
        level = LogLevel.getFromProperties();
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("");
        switch (level)
        {
            case INFO:
                builder.append("[INFO]");
                break;
            case DEBUG:
                builder.append("[DEBUG]");
                break;
            case ERROR:
                builder.append("[ERROR]");
                break;
        }
        builder.append("[").append(threadName).append("]");
        builder.append(content);
        return builder.toString();
    }


    public LogEntity info(String msg)
    {
        return new LogEntity(LogLevel.INFO, msg);
    }

    public LogEntity debug(String msg)
    {
        return new LogEntity(LogLevel.DEBUG, msg);
    }

    public LogEntity error(String msg)
    {
        return new LogEntity(LogLevel.ERROR, msg);
    }

    public String getContent()
    {
        return content;
    }

    public String getThreadName()
    {
        return threadName;
    }

    public LogLevel getLevel()
    {
        return level;
    }
}
