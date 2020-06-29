package com.shimmeringlight.dp.service.clint;

public enum ModuleEnum
{
    SELECT(-1), GOODS(1), ORDERS(2), USER(3), EXIT(-2);
    private int module;

    ModuleEnum(int module)
    {
        this.module = module;
    }

    public static ModuleEnum valueOf(int val)
    {
        ModuleEnum[] values = ModuleEnum.values();
        for(ModuleEnum value: values)
        {
            if(val == value.getModule())
                return value;
        }
        return null;
    }

    public int getModule()
    {
        return module;
    }

    @Override
    public String toString()
    {
        return String.valueOf(module);
    }
}
