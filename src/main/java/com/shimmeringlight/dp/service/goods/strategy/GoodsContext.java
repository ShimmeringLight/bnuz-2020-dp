package com.shimmeringlight.dp.service.goods.strategy;

import com.shimmeringlight.dp.dao.impl.GoodsMapperImpl;
import com.shimmeringlight.dp.entity.Goods;

/**
 * 商品折扣策略内容类,为单例
 */
public class GoodsContext
{
    private DiscountStrategy discountStrategy;

    public int calcPrice(Goods goods)
    {
        return discountStrategy.calcPrice(goods);
    }

    private static class Instance
    {
        public static final GoodsContext instance = new GoodsContext();
    }


    public static GoodsContext getInstance()
    {
        return GoodsContext.Instance.instance;
    }

    //默认无折扣
    private GoodsContext()
    {
        this.discountStrategy = new NoDiscount();
    }

    public GoodsContext(DiscountStrategy discountStrategy)
    {
        this.discountStrategy = discountStrategy;
    }

    public DiscountStrategy getDiscountStrategy()
    {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy)
    {
        this.discountStrategy = discountStrategy;
    }
}
