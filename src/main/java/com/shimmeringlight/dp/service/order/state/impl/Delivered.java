package com.shimmeringlight.dp.service.order.state.impl;

import com.shimmeringlight.dp.entity.StatusEnum;
import com.shimmeringlight.dp.service.order.state.OrderState;

public class Delivered implements OrderState
{
    @Override
    public void printState()
    {
        System.out.println(StatusEnum.DELIVERED.getMsg());
    }
}
