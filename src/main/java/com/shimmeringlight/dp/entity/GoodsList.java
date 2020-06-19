package com.shimmeringlight.dp.entity;

public class GoodsList
{
    private int goodsListId;

    private int orderId;

    private int goodsId;

    private int goodsAmount;

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
