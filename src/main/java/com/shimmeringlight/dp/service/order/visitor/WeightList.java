package com.shimmeringlight.dp.service.order.visitor;

import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.entity.GoodsList;

import java.util.List;

/**
 * 重量清单类
 */
public class WeightList implements ItemPart
{

    private List<GoodsList> goodsLists;

    public WeightList(List<GoodsList> goodsLists)
    {
        this.goodsLists = goodsLists;
    }

    public List<GoodsList> getGoodsLists()
    {
        return goodsLists;
    }

    public void setGoodsLists(List<GoodsList> goodsLists)
    {
        this.goodsLists = goodsLists;
    }

    @Override
    public void accept(OrderPrintVisitor orderPrintVisitor)
    {
        orderPrintVisitor.visit(this);
    }
}
