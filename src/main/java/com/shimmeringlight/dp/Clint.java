package com.shimmeringlight.dp;

import com.shimmeringlight.dp.service.clint.ClintService;
import com.shimmeringlight.dp.service.clint.ClintServiceImpl;

public class Clint
{
    /**
     * 目前只有用户名root，密码123456
     * 用户模块没有实现
     */
    public static void main(String[] args)
    {
        ClintService clintService = ClintServiceImpl.getInstance();
        clintService.startMain();
    }
}
