package com.shimmeringlight.dp.service.goods.strategy;

import com.shimmeringlight.dp.entity.Goods;

/**
 * 折扣策略接口
 */
public interface DiscountStrategy
{
    /**
     * 计算最终价格
     *
     * @param goods 商品
     * @return 最终价格
     */
    int calcPrice(Goods goods);
}
