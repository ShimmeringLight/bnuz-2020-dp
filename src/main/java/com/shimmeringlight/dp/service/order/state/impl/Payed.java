package com.shimmeringlight.dp.service.order.state.impl;

import com.shimmeringlight.dp.entity.StatusEnum;
import com.shimmeringlight.dp.service.order.state.OrderState;

public class Payed implements OrderState
{
    @Override
    public void printState()
    {
        System.out.println(StatusEnum.PAYED.getMsg());
    }
}
