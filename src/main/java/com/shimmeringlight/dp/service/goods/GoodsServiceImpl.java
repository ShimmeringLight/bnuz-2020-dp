package com.shimmeringlight.dp.service.goods;

import com.shimmeringlight.dp.dao.factory.DaoFactory;
import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.service.goods.strategy.DiscountStrategy;
import com.shimmeringlight.dp.service.goods.strategy.GoodsContext;

/**
 * 商品业务逻辑实现，为单例
 */
public class GoodsServiceImpl implements GoodsService
{
    GoodsContext goodsContext = GoodsContext.getInstance();

    @Override
    public int calcFinalPrice(Goods goods)
    {
        return goodsContext.calcPrice(goods);
    }

    private static class Instance
    {
        public static final GoodsServiceImpl instance = new GoodsServiceImpl();
    }


    public static GoodsServiceImpl getInstance()
    {
        return GoodsServiceImpl.Instance.instance;
    }

    private GoodsServiceImpl()
    {
    }

    public GoodsContext getGoodsContext()
    {
        return goodsContext;
    }

    public void setGoodsContext(GoodsContext goodsContext)
    {
        this.goodsContext = goodsContext;
    }
}
