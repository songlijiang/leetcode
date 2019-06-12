package com.leetcode.core;

/**
 * @author songlijiang
 * @version 2019/6/11 17:19
 */
public class AddString {

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int carry = 0;
        while (index1>=0 || index2>=0){

            int value1 = index1<0? 0 : Character.getNumericValue(num1.charAt(index1));
            int value2 = index2<0? 0 : Character.getNumericValue(num2.charAt(index2));

            int temp = value1+value2+carry;

            sb.append(temp%10);
            carry=temp/10;
            index1--;
            index2--;
        }
        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addStrings("9","99"));
    }
}
