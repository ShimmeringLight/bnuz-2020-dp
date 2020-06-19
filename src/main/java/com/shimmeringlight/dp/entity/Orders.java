package com.shimmeringlight.dp.entity;

import com.shimmeringlight.dp.utils.annotations.Login;

@Login
public class Orders
{
    private int orderId;

    private int orderPrice;

    private int num;

    private int weight;

    public Orders()
    {
    }

    @Override
    public String toString()
    {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderPrice=" + orderPrice +
                ", num=" + num +
                ", weight=" + weight +
                '}';
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public int getOrderPrice()
    {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice)
    {
        this.orderPrice = orderPrice;
    }

    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }
}
