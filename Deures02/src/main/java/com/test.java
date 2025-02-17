package com;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generaArrayDecimals(3)));
    }
    public static double[] generaArrayDecimals(int mida) {
        double[] rst = new double[mida];
        for (int i = 0; i < mida; i++) {
            rst[i] =  Math.random() * 100;
        }
        return rst;
    }
}
