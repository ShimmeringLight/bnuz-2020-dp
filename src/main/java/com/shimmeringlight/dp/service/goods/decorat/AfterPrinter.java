package com.shimmeringlight.dp.service.goods.decorat;

import com.shimmeringlight.dp.entity.Goods;

/**
 * 打印商品尾部
 */
public class AfterPrinter extends PrintDecorator
{
    public AfterPrinter(GoodsPrinter printer)
    {
        super(printer);
    }

    @Override
    public void print(Goods goods)
    {
        decoratedPrinter.print(goods);
        System.out.println("重量：" + goods.getWeight());
        System.out.println("库存：" + goods.getInventory());
    }
}
