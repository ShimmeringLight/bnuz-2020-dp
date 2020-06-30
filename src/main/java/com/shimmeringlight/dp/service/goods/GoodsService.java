package com.shimmeringlight.dp.service.goods;

import com.shimmeringlight.dp.entity.Goods;

import java.util.Scanner;

/**
 * 商品业务逻辑
 */
public interface GoodsService
{
    /**
     * 计算最终价格
     *
     * @param goods 商品
     * @return 最终价格
     */
    int calcFinalPrice(Goods goods);

    /**
     * 功能选择
     *
     * @param input 键盘输入
     */
    void selectFunction(Scanner input);

    /**
     * 更新商品功能
     *
     * @param input 键盘输入
     */
    void updateFunction(Scanner input);

    /**
     * 删除商品功能
     *
     * @param input 键盘输入
     */
    void deleteFunction(Scanner input);

    /**
     * 插入功能
     *
     * @param input 键盘输入
     */
    void insertFunction(Scanner input);

    /**
     * 根据商品名查询功能
     *
     * @param input 键盘输入
     */
    void queryNameFunction(Scanner input);

    /**
     * 查询所有商品功能
     */
    void queryAll();

    /**
     * 设置折扣策略功能，默认正常折扣
     */
    void setStrategyFunction(Scanner input);

    /**
     * 打印商品功能
     * @param input 键盘输入
     */
    void startPrint(Scanner input);
}
