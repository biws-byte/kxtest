package com.biws;

import java.math.BigDecimal;

public class test2 {

    private static void testScale() {
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(100));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(100d));
        BigDecimal bigDecimal3 = BigDecimal.valueOf(100d);
        BigDecimal bigDecimal4 = new BigDecimal("100");
        BigDecimal bigDecimal5 = new BigDecimal(String.valueOf(100));

        print(bigDecimal1);
        print(bigDecimal2);
        print(bigDecimal3);
        print(bigDecimal4);
        print(bigDecimal5);
    }

    private static void print(BigDecimal bigDecimal) {
        System.out.println(String.format("scale %s precision %s result %s", bigDecimal.scale(), bigDecimal.precision(), bigDecimal.multiply(new BigDecimal("1.001"))));
    }
    public static void main(String[] args) {
        testScale();
    }

}