package com.shimmeringlight.dp.service.order.visitor;

/**
 * 订单元素接口
 */
public interface ItemPart
{
    void accept(OrderPrintVisitor orderPrintVisitor);
}
