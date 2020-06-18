package com.shimmeringlight.dp.entity;

public class Goods
{
    private int goodId;
    //原价
    private int oriPrice;
    //折扣，0-100
    private int discount;

    private int weight;
    //库存
    private int inventory;

    private String goodsName;

    public Goods(int oriPrice, int discount, int weight, int inventory, String goodsName)
    {
        this.oriPrice = oriPrice;
        this.discount = discount;
        this.weight = weight;
        this.inventory = inventory;
        this.goodsName = goodsName;
    }

    public Goods()
    {
    }

    public int getGoodId()
    {
        return goodId;
    }

    public void setGoodId(int goodId)
    {
        this.goodId = goodId;
    }

    public int getOriPrice()
    {
        return oriPrice;
    }

    public void setOriPrice(int oriPrice)
    {
        this.oriPrice = oriPrice;
    }

    public int getDiscount()
    {
        return discount;
    }

    public void setDiscount(int discount)
    {
        this.discount = discount;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public int getInventory()
    {
        return inventory;
    }

    public void setInventory(int inventory)
    {
        this.inventory = inventory;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }
}
