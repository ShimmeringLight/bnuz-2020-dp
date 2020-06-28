package com.shimmeringlight.dp.entity;

import java.util.HashMap;
import java.util.List;

public class OrderVo
{
    //id
    private int orderId;
    //订单总价
    private int orderPrice;
    //商品总数
    private int num;
    //总重量
    private int weight;
    //订单商品列表
    //key商品id
    //value商品数量
    private HashMap<Integer,Integer> goodsMap;

    private List<GoodsList> goodsLists;

    public List<GoodsList> getGoodsLists()
    {
        return goodsLists;
    }

    public void setGoodsLists(List<GoodsList> goodsLists)
    {
        this.goodsLists = goodsLists;
    }

    public OrderVo()
    {
    }

    public OrderVo(int orderId, int orderPrice, int num, int weight, HashMap<Integer, Integer> goodsMap)
    {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.num = num;
        this.weight = weight;
        this.goodsMap = goodsMap;
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

    public HashMap<Integer, Integer> getGoodsMap()
    {
        return goodsMap;
    }

    public void setGoodsMap(HashMap<Integer, Integer> goodsMap)
    {
        this.goodsMap = goodsMap;
    }
}
