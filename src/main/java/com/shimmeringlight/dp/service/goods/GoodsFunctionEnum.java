package com.shimmeringlight.dp.service.goods;

/**
 * 功能枚举
 */
public enum GoodsFunctionEnum
{
    SELECT(0, "功能选择"),
    SET_STRATEGY(1, "设置策略"),
    UPDATE(2, "更新商品数据"),
    DELETE(3, "删除商品"),
    INSERT(4, "增加商品"),
    QUERY_NAME(5, "根据名称查询"),
    QUERY_ALL(6, "查询全部"),
    EXIT(-1, "返回模块选择");
    private int code;

    private String name;

    GoodsFunctionEnum(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static GoodsFunctionEnum valueOf(int value)
    {
        GoodsFunctionEnum[] values = GoodsFunctionEnum.values();
        for(GoodsFunctionEnum g: values)
        {
            if(g.getCode() == value)
                return g;
        }
        return null;
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.code);
    }

    public int getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }
}
