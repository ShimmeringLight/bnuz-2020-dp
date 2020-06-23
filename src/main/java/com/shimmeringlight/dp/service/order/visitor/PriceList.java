package com.shimmeringlight.dp.service.order.visitor;

import com.shimmeringlight.dp.entity.GoodsList;

import java.util.List;

/**
 * 价格清单
 */
public class PriceList implements ItemPart
{
    private List<GoodsList> lists;

    @Override
    public void accept(OrderPrintVisitor orderPrintVisitor)
    {
        orderPrintVisitor.visit(this);
    }

    public PriceList(List<GoodsList> lists)
    {
        this.lists = lists;
    }

    public List<GoodsList> getLists()
    {
        return lists;
    }

    public void setLists(List<GoodsList> lists)
    {
        this.lists = lists;
    }
}
