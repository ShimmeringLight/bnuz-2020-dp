package com.shimmeringlight.dp.service.goods.decorat;

import com.shimmeringlight.dp.entity.Goods;

/**
 * 商品打印装饰器
 */
public abstract class PrintDecorator implements GoodsPrinter
{
    protected GoodsPrinter decoratedPrinter;

    public PrintDecorator(GoodsPrinter decoratedPrinter)
    {
        this.decoratedPrinter = decoratedPrinter;
    }

    @Override
    public void print(Goods goods)
    {
        decoratedPrinter.print(goods);
    }
}
