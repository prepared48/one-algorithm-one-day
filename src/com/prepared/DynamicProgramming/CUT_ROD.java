package com.prepared.DynamicProgramming;

/**
 * @program: algorithms
 * @description: rod cut problem
 * @author: prepared
 * @create: 2018-09-20 08:06
 **/
public class CUT_ROD {

    /**
     *
     * @param p prices
     * @param n totoal length of the rod
     */
    public static int cutRod(int [] p, int n) {
        if(n == 0) return 0;
        int q = Integer.MAX_VALUE;
        return q;
    }

    public static void main(String[] args) {

        int [] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int n = 4;

        int earn = cutRod(p, n);
        System.out.println("total：" + earn + " yuan");

    }
}
