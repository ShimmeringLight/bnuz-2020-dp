package com.shimmeringlight.dp.service.login;

/**
 * 记录登录状态，来实现登录状态保持
 */
public class LoginRetention
{
    private static boolean Login;

    public static boolean isLogin()
    {
        return Login;
    }

    public static void setIsLogin(boolean isLogin)
    {
        LoginRetention.Login = isLogin;
    }

    private LoginRetention()
    {
    }
}
