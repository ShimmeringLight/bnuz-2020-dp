package com.shimmeringlight.dp.service.goods;

import com.shimmeringlight.dp.service.goods.strategy.DiscountStrategy;
import com.shimmeringlight.dp.service.goods.strategy.PlainDiscount;

/**
 * 商品模块环境类
 */
public class GoodsContext
{
    /**
     * 当前折扣策略策略，默认正常折扣
     */
    private static DiscountStrategy strategy = new PlainDiscount();

    /**
     * 当前执行的功能，默认为功能选择
     */
    private static GoodsFunctionEnum currentFunction = GoodsFunctionEnum.SELECT;

    public static GoodsFunctionEnum getCurrentFunction()
    {
        return currentFunction;
    }

    public static void setCurrentFunction(GoodsFunctionEnum currentFunction)
    {
        GoodsContext.currentFunction = currentFunction;
    }

    public static DiscountStrategy getStrategy()
    {
        return strategy;
    }

    public static void setStrategy(DiscountStrategy strategy)
    {
        GoodsContext.strategy = strategy;
    }

    private GoodsContext()
    {
    }
}
