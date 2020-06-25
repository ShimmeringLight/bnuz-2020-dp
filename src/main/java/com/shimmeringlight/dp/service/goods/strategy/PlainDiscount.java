package com.shimmeringlight.dp.service.goods.strategy;

import com.shimmeringlight.dp.entity.Goods;

/**
 * 正常打折策略，最终价格 = 原价 * 折扣
 */
public class PlainDiscount implements DiscountStrategy
{
    @Override
    public int calcPrice(Goods goods)
    {
        return (int) Math.floor(goods.getOriPrice() * goods.getDiscount() * 0.01);
    }

    @Override
    public String toString()
    {
        return "正常折扣策略";
    }

    //单例
    private static class Instance
    {
        public static final PlainDiscount instance = new PlainDiscount();
    }


    public static PlainDiscount getInstance()
    {
        return PlainDiscount.Instance.instance;
    }
}
