package com.shimmeringlight.dp.service.goods.strategy;

import com.shimmeringlight.dp.entity.Goods;

/**
 * 无折扣策略,最终价格 = 原价
 */
public class NoDiscount implements DiscountStrategy
{
    @Override
    public int calcPrice(Goods goods)
    {
        return goods.getOriPrice();
    }
}
