package com.shimmeringlight.dp.service.goods;

import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.service.goods.strategy.DiscountStrategy;

/**
 * 商品业务逻辑
 */
public interface GoodsService
{
    /**
     * 计算最终价格
     * @param goods 商品
     * @return 最终价格
     */
    int calcFinalPrice(Goods goods);
}
