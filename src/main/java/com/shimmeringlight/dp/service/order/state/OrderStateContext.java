package com.shimmeringlight.dp.service.order.state;

/**
 * 订单状态环境
 */
public class OrderStateContext
{
    private OrderState state;

    public OrderStateContext(OrderState state)
    {
        this.state = state;
    }

    public OrderStateContext()
    {
        state = null;
    }

    public OrderState getState()
    {
        return state;
    }

    public void setState(OrderState state)
    {
        this.state = state;
    }
}
