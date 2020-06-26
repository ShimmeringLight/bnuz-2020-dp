package com.shimmeringlight.dp.service.order;

import com.shimmeringlight.dp.dao.GoodsListMapper;
import com.shimmeringlight.dp.dao.OrdersMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.entity.GoodsList;
import com.shimmeringlight.dp.entity.Orders;
import com.shimmeringlight.dp.service.order.visitor.*;
import com.shimmeringlight.dp.utils.Utils;

import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService
{
    OrdersMapper ordersMapper = DaoFactoryImpl.getInstance().buildOrdersMapper();

    GoodsListMapper goodsListMapper = DaoFactoryImpl.getInstance().buildGoodsListMapper();

    @Override
    public void startSelect(Scanner input)
    {
        do
        {
            System.out.println("请选择功能");
            Utils.printFunction(OrderFunctionEnum.PRINT.getName(),OrderFunctionEnum.PRINT.getCode());
            Utils.printFunction(OrderFunctionEnum.UPDATE.getName(),OrderFunctionEnum.UPDATE.getCode());
            Utils.printFunction(OrderFunctionEnum.DELETE.getName(),OrderFunctionEnum.DELETE.getCode());
            Utils.printFunction(OrderFunctionEnum.INSERT.getName(),OrderFunctionEnum.INSERT.getCode());
            Utils.printFunction(OrderFunctionEnum.QUERY_FULL.getName(),OrderFunctionEnum.QUERY_FULL.getCode());
            Utils.printFunction(OrderFunctionEnum.QUERY_ALL.getName(),OrderFunctionEnum.QUERY_ALL.getCode());
            Utils.printFunction(OrderFunctionEnum.EXIT.getName(),OrderFunctionEnum.EXIT.getCode());
            OrderContext.setCurrentFunction(OrderFunctionEnum.valueOf(input.nextInt()));
            switch (OrderContext.getCurrentFunction())
            {
                case QUERY_ALL:
                    this.startQueryAll(input);
                    break;
                case UPDATE:
                    this.startUpdate(input);
                    break;
                case DELETE:
                    this.startDelete(input);
                    break;
                case INSERT:
                    this.startInsert(input);
                    break;
                case EXIT:
                case SELECT:
                    break;
                case PRINT:
                    this.startPrint(input);
                    break;
                case QUERY_FULL:
                    this.startQueryFull(input);
                    break;

            }
        }while (OrderContext.getCurrentFunction() != OrderFunctionEnum.EXIT);
    }

    @Override
    public void startPrint(Scanner input)
    {
        System.out.println("请输入订单id");
        int id  = input.nextInt();
        Orders orders = ordersMapper.findById(id);
        System.out.println("请选择打印订单部分，可多选");
        Utils.printFunction("价格清单",1);
        Utils.printFunction("重量清单",2);
        Utils.printFunction("装箱数量清单",3);
        String selection = input.next();
        OrderPrintVisitor visitor = new OrderPrintVisitorImpl();
        List<GoodsList> goodsLists = goodsListMapper.findByOrderId(id);
        if(selection.contains("1"))
            visitor.getItemPartList().add(new PriceList(goodsLists));
        if(selection.contains("2"))
            visitor.getItemPartList().add(new WeightList(goodsLists));
        if(selection.contains("3"))
            visitor.getItemPartList().add(new InventoryList(goodsLists));
        visitor.print();
    }

    @Override
    public void startUpdate(Scanner input)
    {

    }

    @Override
    public void startDelete(Scanner input)
    {

    }

    @Override
    public void startInsert(Scanner input)
    {

    }

    @Override
    public void startQueryFull(Scanner input)
    {

    }

    @Override
    public void startQueryAll(Scanner input)
    {

    }
}
