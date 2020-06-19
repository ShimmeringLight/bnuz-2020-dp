package com.shimmeringlight.dp.entity;

public class Orders
{
    private int orderId;

    private int orderPrice;

    private int num;

    private int weight;

    private int goodsListId;

    public Orders(int orderPrice, int num, int weight, int goodsListId)
    {
        this.orderPrice = orderPrice;
        this.num = num;
        this.weight = weight;
        this.goodsListId = goodsListId;
    }

    public Orders()
    {
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

    public int getGoodsListId()
    {
        return goodsListId;
    }

    public void setGoodsListId(int goodsListId)
    {
        this.goodsListId = goodsListId;
    }
}
