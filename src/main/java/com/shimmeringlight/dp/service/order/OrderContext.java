package com.shimmeringlight.dp.service.order;


/**
 * 订单模块环境类
 */
public class OrderContext
{
    //当前功能
    private static OrderFunctionEnum currentFunction = OrderFunctionEnum.SELECT;

    public static OrderFunctionEnum getCurrentFunction()
    {
        return currentFunction;
    }

    public static void setCurrentFunction(OrderFunctionEnum currentFunction)
    {
        OrderContext.currentFunction = currentFunction;
    }
}
