package com.shimmeringlight.dp.service.order.visitor;

import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.OrdersMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.entity.GoodsList;
import com.shimmeringlight.dp.entity.Orders;
import com.shimmeringlight.dp.service.goods.GoodsService;
import com.shimmeringlight.dp.service.goods.GoodsServiceImpl;

public class OrderPrintVisitorImpl implements OrderPrintVisitor
{
    GoodsMapper goodsMapper = DaoFactoryImpl.getInstance().buildGoodsMapper();

    GoodsService goodsService = GoodsServiceImpl.getInstance();

    OrdersMapper ordersMapper = DaoFactoryImpl.getInstance().buildOrdersMapper();

    @Override
    public void visit(PriceList priceList)
    {
        for (GoodsList goodsLists : priceList.getLists())
        {
            Goods current = goodsMapper.findById(goodsLists.getGoodsId());
            System.out.println("商品编号\t商品名\t原价\t折扣价\t总价");
            System.out.println(
                    current.getGoodId() + "\t" +
                            current.getGoodsName() + "\t" +
                            current.getOriPrice() + "\t" +
                            goodsService.calcFinalPrice(current) + "\t" +
                            goodsLists.getFinalPrice());
        }
    }

    @Override
    public void visit(InventoryList inventoryList)
    {
        for (GoodsList goodsLists : inventoryList.getLists())
        {
            Goods current = goodsMapper.findById(goodsLists.getGoodsId());
            Orders orders = ordersMapper.findById(goodsLists.getOrderId());
            System.out.println("商品编号\t商品名\t数量");
            System.out.println(current.getGoodId() + "\t" + current.getGoodsName() + "\t" + orders.getNum());
        }
    }

    @Override
    public void visit(WeightList weightList)
    {
        for (GoodsList lists : weightList.getGoodsLists())
        {
            Goods current = goodsMapper.findById(lists.getGoodsId());
            Orders orders = ordersMapper.findById(lists.getOrderId());
            System.out.println("商品编号\t商品名\t重量\t总重量");
            System.out.println(
                    current.getGoodId() + "\t" +
                            current.getGoodsName() + "\t" +
                            current.getWeight() + "\t" +
                            orders.getWeight());
        }
    }
}
