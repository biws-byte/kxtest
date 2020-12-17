package com.biws;

import java.math.BigDecimal;

public class test3 {
    public static void main(String[] args) {
        double num1 = 3.35;
        float num2 = 3.35f;
        System.out.println(String.format("%.1f", num1));
        System.out.println(String.format("%.1f", num2));


        //改变格式
        BigDecimal num3 = new BigDecimal("3.35");
//小数点后1位，向下舍入
        BigDecimal num4 = num3.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println(num2);
//小数点后1位，四舍五入
        BigDecimal num5 = num3.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(num3);
    }
}
