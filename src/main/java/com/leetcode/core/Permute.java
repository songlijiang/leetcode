package com.leetcode.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permute {


    public static List<List<Integer>> permute(int[] nums) {

        //1。第一位确定后的初始状态，有 n(n-1)个 root

        //2. 每个root 从第2个开始往后交换 swap(2,3)   swap(2,4)...
        //3.上面又产生了新的子数  对于swap(2,3) 的开始 swap(3,4)  swap(3,5)
        //4. 直到没有后续的待交换数字
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <nums.length ; i++) {

            List<Integer> root = new ArrayList<>();

            root.add(nums[i]);
            permute0(root,0,nums,result);
        }

        return result;
    }

    private static void permute0(List<Integer> root, int i, int[] nums,List<List<Integer>> result) {
        i++;

        //从i+1 下标开始

        //没有后续元素了
        if(i==nums.length){
            result.add(root);
        }

        // 处理 i+1 和后续的所有的数字
        for (int j = 0; j < nums.length; j++) {
            List<Integer> array = copy(root);
            int temp = nums[j];
            if(check(array,temp)){
                array.add(temp);
                permute0(array,i,nums,result);
            }
        }

    }

    private static boolean check(List<Integer> array, int temp) {
        return !array.contains(temp);
    }

    private static List<Integer> copy(List<Integer> source){
        List<Integer> target = new ArrayList<>(source.size());
        target.addAll(source);
        return target;
    }


    public static void main(String[] args) {
        int[] test = {1,2,3};
        System.out.println(permute(test));
    }

}
