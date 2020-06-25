package com.shimmeringlight.dp.service.clint;

public enum ModuleEnum
{
    SELECT(-1),GOODS(1),ORDERS(2),USER(3),EXIT(-2);
    private int module;

    ModuleEnum(int module)
    {
        this.module = module;
    }

    public static ModuleEnum valueOf(int val)
    {
        switch (val)
        {
            case -1:
                return SELECT;
            case 1:
                return GOODS;
            case 2:
                return ORDERS;
            case 3:
                return USER;
            case -2:
                return EXIT;
        }
        return null;
    }

    @Override
    public String toString()
    {
        return String.valueOf(module);
    }
}
