package com.shimmeringlight.dp.entity;

import java.util.Scanner;

public enum StatusEnum
{
    WAIT_PAY('A',"待支付"),
    PAYED('B',"已支付"),
    WAIT_DELI('C',"待快递"),
    DELIVERED('D',"已快递"),
    ARRIVED('E',"已到达"),
    RECEIVED('F',"已收获"),
    REFUNDABLE('G',"可退换"),
    NOT_REFUNDABLE('H',"不可退换")
    ;

    //订单状态码
    private char chr;

    //订单状态
    private String msg;

    public static StatusEnum getStatusFromInput(Scanner input)
    {
        System.out.println("请选择状态");
        StatusEnum[] values = StatusEnum.values();
        int count = 0;
        for (StatusEnum value : values)
        {
            count++;
            System.out.print("【" + value.getChr() + "】" + value.getMsg());
            if(count % 4 == 0)
                System.out.println();
        }
        do
        {
            char c = input.next().charAt(0);
            StatusEnum result = valueOf(c);
            if(result != null)
                return result;
        }while (true);
    }

    public static StatusEnum valueOf(char chr)
    {
        StatusEnum[] values = StatusEnum.values();
        for (StatusEnum value : values)
        {
            if (chr == value.getChr())
                return value;
        }
        return null;
    }

    StatusEnum(char chr,String msg)
    {
        this.chr = chr;
        this.msg = msg;
    }

    public char getChr()
    {
        return chr;
    }

    public void setChr(char chr)
    {
        this.chr = chr;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
