package com.shimmeringlight.dp.service.order;

import com.shimmeringlight.dp.entity.OrderPo;
import com.shimmeringlight.dp.entity.OrderVo;

import java.util.Scanner;

/**
 * 订单业务逻辑接口
 */
public interface OrderService
{
    /**
     * vo转换为po
     * @param vo vo
     * @return po
     */
    OrderPo convertToPo(OrderVo vo);

    /**
     * po转换为vo
     * @param po po
     * @return vo
     */
    OrderVo convertToVo(OrderPo po);

    /**
     * 功能选择
     * @param input 键盘输入
     */
    void startSelect(Scanner input);

    /**
     * 打印订单商品清单功能
     * @param input 键盘输入
     */
    void startPrint(Scanner input);

    /**
     * 更新订单信息功能
     * @param input 键盘输入
     */
    void startUpdate(Scanner input);

    /**
     * 删除订单信息功能
     * @param input 键盘输入
     */
    void startDelete(Scanner input);

    /**
     * 增加订单功能
     * @param input 键盘输入
     */
    void startInsert(Scanner input);

    /**
     * 根据完整订单信息查询功能
     * @param input 键盘输入
     */
    void startQueryFull(Scanner input);

    /**
     * 查询所有功能
     * @param input 键盘输入
     */
    void startQueryAll(Scanner input);
}
