package com.shimmeringlight.dp.service.login;

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
