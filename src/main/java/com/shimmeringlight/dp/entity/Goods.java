package com.shimmeringlight.dp.entity;

import java.util.Scanner;

/**
 * 商品实体类
 */
public class Goods
{
    //商品id
    private int goodId;
    //原价
    private int oriPrice;
    //折扣，0-100
    private int discount;
    //商品重量
    private int weight;
    //库存
    private int inventory;
    //商品名
    private String goodsName;

    public Goods(int oriPrice, int discount, int weight, int inventory, String goodsName)
    {
        this.oriPrice = oriPrice;
        this.discount = discount;
        this.weight = weight;
        this.inventory = inventory;
        this.goodsName = goodsName;
    }

    public Goods(Scanner input)
    {
        System.out.println("请输入商品名称");
        this.goodsName = input.next();
        System.out.println("请输入原价");
        this.oriPrice = input.nextInt();
        System.out.println("请输入折扣% 0-100");
        this.discount = input.nextInt();
        System.out.println("请输入商品重量");
        this.weight = input.nextInt();
        System.out.println("请输入库存");
        this.inventory = input.nextInt();
    }

    @Override
    public String toString()
    {
        return "Goods{" +
                "goodId=" + goodId +
                ", oriPrice=" + oriPrice +
                ", discount=" + discount +
                ", weight=" + weight +
                ", inventory=" + inventory +
                ", goodsName='" + goodsName + '\'' +
                '}';
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
