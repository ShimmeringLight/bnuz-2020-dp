package com.shimmeringlight.dp.service.order;

public enum OrderFunctionEnum
{
    SELECT(0, "功能选择"),
    PRINT(1, "打印订单"),
    UPDATE(2, "更新订单数据"),
    DELETE(3, "删除订单"),
    INSERT(4, "增加订单"),
    QUERY_FULL(5, "根据完整信息查询"),
    QUERY_ALL(6, "查询全部"),
    EXIT(-1, "返回模块选择");
    private int code;

    private String name;

    OrderFunctionEnum(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static OrderFunctionEnum valueOf(int code)
    {
        switch (code)
        {
            case 0:
                return SELECT;
            case 1:
                return PRINT;
            case 2:
                return UPDATE;
            case 3:
                return DELETE;
            case 4:
                return INSERT;
            case 5:
                return QUERY_FULL;
            case 6:
                return QUERY_ALL;
            case -1:
                return EXIT;
        }
        return null;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
