package com.leetcode.core;

import java.util.*;

/**
 * @author songlijiang
 * @version 2019/6/21 15:15
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxSubLength = 1;
        int length = s.length();
        int tempLength = 0;
        int minIndex = 0;
        boolean miniInited = false;
        Map<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);

            Integer index = temp.get(current);
            if (index==null) {
                temp.put(current, i);
                tempLength++;
            }else if(index<minIndex && miniInited){
                temp.put(current, i);
                tempLength++;
            }else{
                minIndex=index+1;
                miniInited=true;
                tempLength = i-minIndex+1 ;
                temp.put(current, i);
            }
            if (maxSubLength < tempLength) {
                maxSubLength = tempLength;
            }
        }
        return maxSubLength;

    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abwfwebba"));
    }
}
