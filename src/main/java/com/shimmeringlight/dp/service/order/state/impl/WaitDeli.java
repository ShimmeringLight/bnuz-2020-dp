package com.shimmeringlight.dp.service.order.state.impl;

import com.shimmeringlight.dp.entity.StatusEnum;
import com.shimmeringlight.dp.service.order.state.OrderState;

public class WaitDeli implements OrderState
{
    @Override
    public void printState()
    {
        System.out.println(StatusEnum.WAIT_DELI.getMsg());
    }
}
