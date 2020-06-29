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
        OrderFunctionEnum[] values = OrderFunctionEnum.values();
        for(OrderFunctionEnum value: values)
        {
            if(value.getCode() == code)
                return value;
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
