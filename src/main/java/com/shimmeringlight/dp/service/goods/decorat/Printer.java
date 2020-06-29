package com.shimmeringlight.dp.service.goods.decorat;

import com.shimmeringlight.dp.entity.Goods;

/**
 * 商品打印实现，打印商品中部
 */
public class Printer implements GoodsPrinter
{
    @Override
    public void print(Goods goods)
    {
        System.out.println("商品名：" + goods.getGoodsName());
    }
}
