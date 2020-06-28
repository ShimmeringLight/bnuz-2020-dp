package com.shimmeringlight.dp.service.order;

import com.shimmeringlight.dp.dao.GoodsListMapper;
import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.OrdersMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.entity.GoodsList;
import com.shimmeringlight.dp.entity.OrderPo;
import com.shimmeringlight.dp.entity.OrderVo;
import com.shimmeringlight.dp.service.goods.GoodsService;
import com.shimmeringlight.dp.service.goods.GoodsServiceImpl;
import com.shimmeringlight.dp.service.goodslist.GoodsListService;
import com.shimmeringlight.dp.service.goodslist.GoodsListServiceImpl;
import com.shimmeringlight.dp.service.order.visitor.*;
import com.shimmeringlight.dp.utils.Utils;

import java.util.*;

public class OrderServiceImpl implements OrderService
{
    OrdersMapper ordersMapper = DaoFactoryImpl.getInstance().buildOrdersMapper();

    GoodsListMapper goodsListMapper = DaoFactoryImpl.getInstance().buildGoodsListMapper();

    GoodsMapper goodsMapper = DaoFactoryImpl.getInstance().buildGoodsMapper();

    GoodsService goodsService = GoodsServiceImpl.getInstance();

    GoodsListService goodsListService = GoodsListServiceImpl.getInstance();

    @Override
    public OrderPo convertToPo(OrderVo vo)
    {
        return new OrderPo(vo.getOrderId(),vo.getOrderPrice(),vo.getNum(),vo.getWeight());
    }

    @Override
    public OrderVo convertToVo(OrderPo po)
    {
        HashMap<Integer,Integer> goodsMap = new HashMap<>();
        List<GoodsList> lists = goodsListMapper.findByOrderId(po.getOrderId());
        OrderVo vo = new OrderVo();
        vo.setGoodsLists(lists);
        int num = 0;
        int price = 0;
        int weight = 0;
        for(GoodsList g:vo.getGoodsLists())
        {
            goodsMap.put(g.getGoodsId(),g.getGoodsAmount());
            Goods goods = goodsMapper.findById(g.getGoodsId());
            num += g.getGoodsAmount();
            price += g.getGoodsAmount() * goodsService.calcFinalPrice(goods);
            weight += g.getGoodsAmount() * goods.getWeight();
        }
        vo.setNum(num);
        vo.setGoodsMap(goodsMap);
        vo.setWeight(weight);
        vo.setOrderPrice(price);
        return vo;
    }

    @Override
    public void startSelect(Scanner input)
    {
        do
        {
            System.out.println("请选择功能");
            Utils.printlnFunction(OrderFunctionEnum.PRINT.getCode(), OrderFunctionEnum.PRINT.getName());
            Utils.printlnFunction(OrderFunctionEnum.UPDATE.getCode(), OrderFunctionEnum.UPDATE.getName());
            Utils.printlnFunction(OrderFunctionEnum.DELETE.getCode(), OrderFunctionEnum.DELETE.getName());
            Utils.printlnFunction(OrderFunctionEnum.INSERT.getCode(), OrderFunctionEnum.INSERT.getName());
            Utils.printlnFunction(OrderFunctionEnum.QUERY_FULL.getCode(), OrderFunctionEnum.QUERY_FULL.getName());
            Utils.printlnFunction(OrderFunctionEnum.QUERY_ALL.getCode(), OrderFunctionEnum.QUERY_ALL.getName());
            Utils.printlnFunction(OrderFunctionEnum.EXIT.getCode(), OrderFunctionEnum.EXIT.getName());
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
        OrderPo orderPo = ordersMapper.findById(id);
        System.out.println("请选择打印订单部分，可多选");
        Utils.printlnFunction(1, "价格清单");
        Utils.printlnFunction(2, "重量清单");
        Utils.printlnFunction(3, "装箱数量清单");
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
        int id = -2;
        OrderPo orderPo = null;
        do
        {
            System.out.println("请输入订单id，输入-1退出");
            id = input.nextInt();
            if(id == -1)
                return;
            orderPo = ordersMapper.findById(id);
            if(orderPo == null)
                System.out.println("无此订单");
        }while (orderPo != null);
        OrderVo orderVo = this.convertToVo(orderPo);
        System.out.println("序号\t商品id\t商品名\t商品数量\t小计");
        Map<Integer,GoodsList> listMap = new HashMap<>();
        int i = 1;
        for(Map.Entry<Integer,Integer> e:orderVo.getGoodsMap().entrySet())
        {
            Goods goods = goodsMapper.findById(e.getKey());
            GoodsList goodsList = new GoodsList();
            goodsList.setOrderId(orderVo.getOrderId());
            goodsList.setGoodsId(e.getKey());
            goodsList.setGoodsAmount(e.getValue());
            goodsList.setFinalPrice(goodsService.calcFinalPrice(goods) * e.getValue());
            listMap.put(i,goodsListMapper.findByEntity(goodsList));
            System.out.println(i + "\t" + e.getKey() + "\t" + goods.getGoodsName() + "\t" + goodsList.getGoodsAmount() + "\t" + goodsList.getFinalPrice());
            i++;
        }
        System.out.println("请选择操作");
        Map<Integer,String> funcMap = new HashMap<>();
        funcMap.put(1,"增加条目");
        funcMap.put(2,"删除条目");
        funcMap.put(3,"更新条目");
        funcMap.put(-1,"返回功能选择");
        Utils.printFunction(funcMap);
        int func = input.nextInt();
        switch (func)
        {
            case 1:
                GoodsList goodsList = new GoodsList();
                System.out.println("请输入商品id");
                goodsList.setGoodsId(input.nextInt());
                System.out.println("请输入商品数量");
                goodsList.setGoodsAmount(input.nextInt());
                goodsList.setOrderId(orderPo.getOrderId());
                goodsListService.insertByEntity(goodsList);
                break;
            case 2:
                System.out.println("请输入删除条目序号");
                goodsListMapper.deleteById(listMap.get(input.nextInt()).getGoodsListId());
                break;
            case 3:
                System.out.println("请输入更新条目序号");
                int goodsListId = listMap.get(input.nextInt()).getGoodsListId();
                goodsList = new GoodsList();
                System.out.println("请输入商品id");
                goodsList.setGoodsId(input.nextInt());
                System.out.println("请输入商品数量");
                goodsList.setGoodsAmount(input.nextInt());
                goodsList.setOrderId(orderPo.getOrderId());
                goodsList.setGoodsListId(goodsListId);
                goodsList.setFinalPrice(goodsService.calcFinalPrice(goodsMapper.findById(goodsList.getGoodsId())));
                goodsListMapper.updateByEntity(goodsList);
        }
    }

    @Override
    public void startDelete(Scanner input)
    {
        System.out.println("请输入订单id");
        int id = input.nextInt();
        goodsListMapper.deleteByOrderId(id);
        ordersMapper.deleteById(id);
        System.out.println("删除完成");
    }

    @Override
    public void startInsert(Scanner input)
    {
        System.out.println("开始输入订单条目");
        int goodsId = 0;
        List<GoodsList> lists = new ArrayList<>();
        OrderPo orderPo = new OrderPo();
        do
        {
            System.out.println("请输入商品id,输入-1结束输入订单条目");
            goodsId = input.nextInt();
            System.out.println("请输入数量");
            int amount = input.nextInt();
            GoodsList goodsList = new GoodsList();
            goodsList.setGoodsId(goodsId);
            goodsList.setGoodsAmount(amount);
            Goods goods = goodsMapper.findById(goodsId);
            int price = goodsService.calcFinalPrice(goods) * amount;
            orderPo.setNum(orderPo.getNum() + amount);
            orderPo.setOrderPrice(orderPo.getOrderPrice() + price);
            orderPo.setWeight(orderPo.getWeight() + goods.getWeight());
            lists.add(goodsList);
        } while (goodsId != -1);
        ordersMapper.insertByEntity(orderPo);
        int orderId = ordersMapper.findByEntity(orderPo).getOrderId();
        for(GoodsList g:lists)
        {
            g.setOrderId(orderId);
            goodsListMapper.insertByEntity(g);
        }
        System.out.println("新增订单完成");
    }

    /**
     * 未完成....
     * @param input 键盘输入
     */
    @Override
    public void startQueryFull(Scanner input)
    {

    }

    /**
     * 未完成....
     * @param input 键盘输入
     */
    @Override
    public void startQueryAll(Scanner input)
    {

    }
}
