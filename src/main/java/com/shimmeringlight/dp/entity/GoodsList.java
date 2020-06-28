package com.shimmeringlight.dp.entity;

import java.util.Scanner;

/**
 * 订单商品列表实体类
 */
public class GoodsList
{
    //id
    private int goodsListId;
    //订单id
    private int orderId;
    //商品id
    private int goodsId;
    //商品数量
    private int goodsAmount;
    //订单中此条目的最终价格
    private int finalPrice;

    public GoodsList()
    {
    }

    @Override
    public String toString()
    {
        return "GoodsList{" +
                "goodsListId=" + goodsListId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsAmount=" + goodsAmount +
                ", finalPrice=" + finalPrice +
                '}';
    }



    public int getGoodsListId()
    {
        return goodsListId;
    }

    public void setGoodsListId(int goodsListId)
    {
        this.goodsListId = goodsListId;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public int getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(int goodsId)
    {
        this.goodsId = goodsId;
    }

    public int getGoodsAmount()
    {
        return goodsAmount;
    }

    public void setGoodsAmount(int goodsAmount)
    {
        this.goodsAmount = goodsAmount;
    }

    public int getFinalPrice()
    {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice)
    {
        this.finalPrice = finalPrice;
    }
}
