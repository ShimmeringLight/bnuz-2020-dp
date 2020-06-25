package com.shimmeringlight.dp.service.goods;

/**
 * 功能枚举
 */
public enum GoodsFunctionEnum
{
    SELECT(0,"功能选择"),
    SET_STRATEGY(1,"设置策略"),
    UPDATE(2,"更新商品数据"),
    DELETE(3,"删除商品"),
    INSERT(4,"增加商品"),
    QUERY_NAME(5,"根据名称查询"),
    QUERY_ALL(6,"查询全部"),
    EXIT(-1,"返回模块选择");
    private int value;

    private String name;

    GoodsFunctionEnum(int value,String name)
    {
        this.value = value;
        this.name = name;
    }

    public static GoodsFunctionEnum valueOf(int value)
    {
        switch (value)
        {
            case 0:
                return SELECT;
            case 1:
                return SET_STRATEGY;
            case 2:
                return UPDATE;
            case 3:
                return DELETE;
            case 4:
                return INSERT;
            case 5:
                return QUERY_NAME;
            case 6:
                return QUERY_ALL;
            case -1:
                return EXIT;
        }
        return null;
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.value);
    }

    public int getValue()
    {
        return value;
    }

    public String getName()
    {
        return name;
    }
}
