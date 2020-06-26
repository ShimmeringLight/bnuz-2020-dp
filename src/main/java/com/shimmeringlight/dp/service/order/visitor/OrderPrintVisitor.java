package com.shimmeringlight.dp.service.order.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单访问者接口
 */
public abstract class OrderPrintVisitor
{
    List<ItemPart> itemPartList = new ArrayList<>();

    abstract public void visit(PriceList priceList);

    abstract public void visit(InventoryList inventoryList);

    abstract public void visit(WeightList weightList);

    abstract public void print();

    public List<ItemPart> getItemPartList()
    {
        return itemPartList;
    }

    public void setItemPartList(List<ItemPart> itemPartList)
    {
        this.itemPartList = itemPartList;
    }
}
