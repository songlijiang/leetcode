package com.leetcode.core;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Divide {

    /**
     * 通过减法实现，当不够减的时候取一半 比较大小 ，取一半可以位移
     * 符号怎么处理 1。如果2者符号相同则为正2。不同则为负
     * 怎么把正数变为负数？0减
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend ,int divisor){



        boolean isPositive =(dividend ^divisor)>=0;
        long count = 0;
        if(dividend==Integer.MIN_VALUE&& divisor==-1){
            return Integer.MAX_VALUE;
        }
        if(divisor==1){
            return dividend;
        }
        if(divisor==-1){
            return 0-dividend;
        }

        if(divisor==2){
            return dividend>>1;
        }


        // 有可能精度丢失 用long?
        long dividendTemp =dividend<0?0-(long)dividend:dividend;
        long divisorTemp=divisor<0?0-(long)divisor:divisor;

        while (dividendTemp>=divisorTemp){
            count++;
            dividendTemp -=divisorTemp;
        }
        if((dividendTemp >>1) >divisorTemp){
            count++;
        }

        long result= isPositive? count:0-count;

       return (int) result;
    }

    public static void main(String[] args) {
       long start = System.currentTimeMillis();
        System.out.println(8>>1);
        System.out.println(divide(2147483646,2));

        System.out.println(System.currentTimeMillis()-start);
    }




}
