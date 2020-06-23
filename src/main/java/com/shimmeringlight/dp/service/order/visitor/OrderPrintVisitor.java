package com.shimmeringlight.dp.service.order.visitor;

/**
 * 订单访问者接口
 */
public interface OrderPrintVisitor
{
    void visit(PriceList priceList);

    void visit(InventoryList inventoryList);

    void visit(WeightList weightList);
}
