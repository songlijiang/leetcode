package com.leetcode.core;

public class Regular {

    public static boolean match( String source,String pattern){

        //1. 双指针移动,从头到尾
        //2。对于? 可以直接移动一个
        //3。对于 * 可以移动0到多个

        int sIndex = 0;
        int pIndex = 0;

        int sIndexMark=-1;
        int pIndexMark =-1;

        while (sIndex<source.length()){

            if(pIndex<pattern.length() && (source.charAt(sIndex)==pattern.charAt(pIndex) || pattern.charAt(pIndex)=='?')){
                //单个匹配
                sIndex++;
                pIndex++;
            }else if(pIndex<pattern.length() && pattern.charAt(pIndex)=='*'){
                //从当前下标开始可以匹配多个
                sIndexMark = sIndex;
                pIndexMark = pIndex;
                pIndex++;
            }else if(sIndexMark!=-1){
                sIndexMark++;
                sIndex=sIndexMark;//第一次匹配* 的位置往后匹配
                pIndex=pIndexMark+1;//确定位置
            }else {
                return false;
            }
        }

        while (pIndex<pattern.length()){
            //对于后续只能全部是* 不然不匹配
            if(pattern.charAt(pIndex)!='*'){
                return false;
            }
            pIndex++;
        }

        return true;

    }


    public static void main(String[] args) {

        System.out.println(match("acdcb","a*d?b"));

    }

    public static boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        int i = 0;
        int j = 0;
        int start = -1;
        int match = 0;
        while (i < sn) {
            if (j < pn && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pn && p.charAt(j) == '*') {
                start = j;
                match = i;
                j++;
            } else if (start != -1) {
                j = start + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        while (j < pn) {
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;

    }


}
