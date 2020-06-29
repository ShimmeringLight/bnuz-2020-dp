package com.shimmeringlight.dp.service.goods.decorat;

import com.shimmeringlight.dp.entity.Goods;

/**
 * 打印商品头部
 */
public class HeadPrintDecorator extends PrintDecorator
{
    public HeadPrintDecorator(GoodsPrinter printer)
    {
        super(printer);
    }

    @Override
    public void print(Goods goods)
    {
        System.out.println("商品id：" + goods.getGoodId());
        System.out.println("商品原价：" + goods.getOriPrice());
        decoratedPrinter.print(goods);
    }
}
