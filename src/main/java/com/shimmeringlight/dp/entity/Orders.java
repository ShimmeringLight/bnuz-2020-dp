package com.shimmeringlight.dp.entity;

/**
 * 订单实体类
 */
public class Orders
{
    //id
    private int orderId;
    //订单总价
    private int orderPrice;
    //商品总数
    private int num;
    //总重量
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
