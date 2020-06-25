package com.shimmeringlight.dp.service.clint;

import java.util.Scanner;

/**
 * 客户端服务接口
 */
public interface ClintService
{
    void startMain();

    void startSelect(Scanner input);

    void startGoods(Scanner input);

    void startOrders(Scanner input);

    void startUser(Scanner input);
}
