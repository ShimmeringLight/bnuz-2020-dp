package com.shimmeringlight.dp.service.goods;

import com.shimmeringlight.dp.dao.GoodsMapper;
import com.shimmeringlight.dp.dao.factory.DaoFactoryImpl;
import com.shimmeringlight.dp.entity.Goods;
import com.shimmeringlight.dp.service.goods.decorat.*;
import com.shimmeringlight.dp.service.goods.strategy.GoodsContext;
import com.shimmeringlight.dp.service.goods.strategy.NoDiscount;
import com.shimmeringlight.dp.service.goods.strategy.PlainDiscount;
import com.shimmeringlight.dp.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * 商品业务逻辑实现，为单例
 */
public class GoodsServiceImpl implements GoodsService
{
    GoodsContext goodsContext = GoodsContext.getInstance();

    GoodsMapper goodsMapper = DaoFactoryImpl.getInstance().buildGoodsMapper();

    /**
     * 根据策略计算商品价格
     *
     * @param goods 商品
     * @return 商品价格
     */
    @Override
    public int calcFinalPrice(Goods goods)
    {
        return goodsContext.calcPrice(goods);
    }


    @Override
    public void selectFunction(Scanner input)
    {
        while (GoodsContext.getCurrentFunction() != GoodsFunctionEnum.EXIT)
        {
            System.out.println("请选择功能");
            Utils.printlnFunction(GoodsFunctionEnum.SELECT.getCode(), GoodsFunctionEnum.SELECT.getName());
            Utils.printlnFunction(GoodsFunctionEnum.SET_STRATEGY.getCode(), GoodsFunctionEnum.SET_STRATEGY.getName());
            Utils.printlnFunction(GoodsFunctionEnum.UPDATE.getCode(), GoodsFunctionEnum.UPDATE.getName());
            Utils.printlnFunction(GoodsFunctionEnum.DELETE.getCode(), GoodsFunctionEnum.DELETE.getName());
            Utils.printlnFunction(GoodsFunctionEnum.INSERT.getCode(), GoodsFunctionEnum.INSERT.getName());
            Utils.printlnFunction(GoodsFunctionEnum.QUERY_NAME.getCode(), GoodsFunctionEnum.QUERY_NAME.getName());
            Utils.printlnFunction(GoodsFunctionEnum.QUERY_ALL.getCode(), GoodsFunctionEnum.QUERY_ALL.getName());
            GoodsContext.setCurrentFunction(GoodsFunctionEnum.valueOf(input.nextInt()));
            switch (GoodsContext.getCurrentFunction())
            {
                case SELECT:
                    break;
                case EXIT:
                    System.out.println("退出当前功能");
                    break;
                case INSERT:
                    this.insertFunction(input);
                    break;
                case DELETE:
                    this.deleteFunction(input);
                    break;
                case UPDATE:
                    this.updateFunction(input);
                    break;
                case SET_STRATEGY:
                    this.setStrategyFunction(input);
                    break;
                case QUERY_NAME:
                    this.queryNameFunction(input);
                    break;
                case QUERY_ALL:
                    this.queryAll();
                    break;
                case PRINT:
                    this.startPrint(input);
                    break;
                default:
                    System.out.println("请重新选择");
            }
        }
    }

    @Override
    public void updateFunction(Scanner input)
    {
        System.out.println("请输入商品id");
        int id = input.nextInt();
        Goods goods = new Goods(input);
        goods.setGoodId(id);
        goodsMapper.updateByEntity(goods);
        System.out.println("更新完成");
    }

    @Override
    public void deleteFunction(Scanner input)
    {
        System.out.println("请输入商品id");
        int id = input.nextInt();
        goodsMapper.deleteById(id);
        System.out.println("删除完成");
    }

    @Override
    public void insertFunction(Scanner input)
    {
        System.out.println("请输入商品信息：");
        goodsMapper.insertByEntity(new Goods(input));
        System.out.println("插入完成");
    }

    @Override
    public void queryNameFunction(Scanner input)
    {
        System.out.println("请输入商品名称");
        String name = input.next();
        System.out.println("查询到以下商品：");
        System.out.println(goodsMapper.findByName(name));
    }

    @Override
    public void queryAll()
    {
        System.out.println("所有商品：");
        List<Goods> goodsList = goodsMapper.findAll();
        for (Goods goods : goodsList)
        {
            System.out.println(goods);
        }
    }

    @Override
    public void setStrategyFunction(Scanner input)
    {
        int code = -2;
        do
        {
            System.out.println("请选择折扣策略,当前为" + goodsContext.getDiscountStrategy());
            Utils.printlnFunction(1, "无折扣策略");
            Utils.printlnFunction(2, "正常折扣策略");
            Utils.printlnFunction(-1, "退出策略选择");
            code = input.nextInt();
            switch (code)
            {
                case 1:
                    goodsContext.setDiscountStrategy(NoDiscount.getInstance());
                    System.out.println("切换到无折扣策略");
                    break;
                case 2:
                    goodsContext.setDiscountStrategy(PlainDiscount.getInstance());
                    System.out.println("切换到正常折扣策略");
                    break;
                default:
                    System.out.println("请重新选择");
                    break;
            }
        } while (code != -1);

    }

    @Override
    public void startPrint(Scanner input)
    {
        int goodsId;
        System.out.println("开始商品打印，请输入商品id");
        goodsId = input.nextInt();
        Goods goods = goodsMapper.findById(goodsId);
        System.out.println("请输入订单打印部分，可多选");
        Map<Integer,String> partMap = new HashMap<>();
        partMap.put(1,"商品头");
        partMap.put(2,"商品尾");
        Utils.printFunction(partMap);
        String func = input.next();
        GoodsPrinter printer = new Printer();
        if(func.contains("1"))
        {
            PrintDecorator headDecorator = new HeadPrintDecorator(printer);
            headDecorator.print(goods);
        }
        if(func.contains("2"))
        {
            PrintDecorator afterDecorator = new AfterPrinter(printer);
            afterDecorator.print(goods);
        }
    }

    private static class Instance
    {
        public static final GoodsServiceImpl instance = new GoodsServiceImpl();
    }


    public static GoodsServiceImpl getInstance()
    {
        return GoodsServiceImpl.Instance.instance;
    }

    private GoodsServiceImpl()
    {
    }

    public GoodsContext getGoodsContext()
    {
        return goodsContext;
    }

    public void setGoodsContext(GoodsContext goodsContext)
    {
        this.goodsContext = goodsContext;
    }
}
