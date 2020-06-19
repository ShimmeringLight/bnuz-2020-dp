package com.shimmeringlight.dp.entity;

public class GoodsList
{
    private int goodsListId;

    private int goodsId;

    private int goodsAmount;

    private int finalPrice;

    public GoodsList(int goodsId, int goodsAmount, int finalPrice)
    {
        this.goodsId = goodsId;
        this.goodsAmount = goodsAmount;
        this.finalPrice = finalPrice;
    }

    public GoodsList()
    {
    }

    @Override
    public String toString()
    {
        return "GoodsList{" +
                "goodsListId=" + goodsListId +
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
