package com.shimmeringlight.dp.service.clint;

import com.shimmeringlight.dp.log.Log;
import com.shimmeringlight.dp.log.LogFactory;
import com.shimmeringlight.dp.service.goods.GoodsService;
import com.shimmeringlight.dp.service.goods.GoodsServiceImpl;

import java.util.Scanner;

/**
 * 客户端逻辑实现
 */
public class ClintServiceImpl implements ClintService
{
    GoodsService goodsService = GoodsServiceImpl.getInstance();

    ModuleEnum currentModule = ModuleEnum.SELECT;

    Log log = LogFactory.build();

    @Override
    public void startMain()
    {
        Scanner input = new Scanner(System.in);
        this.startSelect(input);
    }

    @Override
    public void startSelect(Scanner input)
    {
        while (currentModule != ModuleEnum.EXIT)
        {
            log.debug("开始模块选择");
            if (currentModule == ModuleEnum.SELECT)
            {
                System.out.println("请选择要进入的模块:");
                System.out.println("【" + ModuleEnum.GOODS + "】商品" +
                        "【" + ModuleEnum.ORDERS + "】订单 " +
                        "【" + ModuleEnum.USER + "】用户 " +
                        "【" + ModuleEnum.SELECT + "】返回模块选择 + " +
                        "【" + ModuleEnum.EXIT + "】退出程序");
                currentModule = ModuleEnum.valueOf(input.nextInt());
            }
            switch (currentModule)
            {
                case USER:
                    this.startUser(input);
                    break;
                case GOODS:
                    this.startGoods(input);
                    break;
                case ORDERS:
                    this.startOrders(input);
                    break;
                case SELECT:
                    this.startSelect(input);
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("请重新选择");
            }
        }
    }

    @Override
    public void startGoods(Scanner input)
    {
        log.debug("进入商品模块");
    }

    @Override
    public void startOrders(Scanner input)
    {
        log.debug("进入订单模块");
    }

    @Override
    public void startUser(Scanner input)
    {
        log.debug("进入用户模块");
    }

    private ClintServiceImpl()
    {
    }

    //单例
    private static class Instance
    {
        public static final ClintServiceImpl instance = new ClintServiceImpl();
    }

    public static ClintServiceImpl getInstance()
    {
        return ClintServiceImpl.Instance.instance;
    }
}
