package com.shimmeringlight.dp.entity;

import com.shimmeringlight.dp.service.goods.strategy.DiscountStrategy;

import java.util.Map;

/**
 * 订单实体类
 */
public class OrderPo
{
    //id
    private int orderId;
    //订单总价
    private int orderPrice;
    //商品总数
    private int num;
    //总重量
    private int weight;
    //订单状态
    private StatusEnum status;

    public StatusEnum getStatus()
    {
        return status;
    }

    public void setStatus(StatusEnum status)
    {
        this.status = status;
    }

    public OrderPo()
    {
        orderPrice = 0;
        num = 0;
        weight = 0;
        status = null;
    }

    public OrderPo(int orderId, int orderPrice, int num, int weight, StatusEnum status)
    {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.num = num;
        this.weight = weight;
        this.status = status;
    }

    public OrderPo(Map<Goods,Integer> goodsList, DiscountStrategy strategy)
    {
        this.orderPrice = 0;
        this.num = 0;
        this.weight = 0;
        for(Map.Entry<Goods,Integer> entry:goodsList.entrySet())
        {
            this.orderPrice += strategy.calcPrice(entry.getKey()) * entry.getValue();
            num += entry.getValue();
            weight += entry.getKey().getWeight() * entry.getValue();
        }
    }

    @Override
    public String toString()
    {
        return "id：" + orderId +
                " 订单总价：" + orderPrice +
                " 商品数量" + num +
                " 总重量" + weight;
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
