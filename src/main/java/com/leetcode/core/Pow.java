package com.leetcode.core;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Pow {


    public static double pow(double x,int n){

        if(n==Integer.MAX_VALUE && x<1&&0<x){
            return 0;
        }
        if(n==Integer.MIN_VALUE && x>1){
                return 0;
        }
        if(x==1){
            return 1;
        }
        if(x==-1){
            return n%2==0?1:-1;
        }

        int remainCount = Math.abs(n);
        double result = 1;
        while (remainCount>0){
            result =result*x;
            remainCount--;
        }
        return n>0? result:1/result;

    }

    public static void main(String[] args) {
        System.out.println(pow(-1.00000,2147483647));
    }



}
