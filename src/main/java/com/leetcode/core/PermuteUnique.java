package com.leetcode.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermuteUnique {

    public static List<List<Integer>> permute(int[] nums) {

        //1。第一位确定后的初始状态，有 n(n-1)个 root

        //2. 每个root 从第2个开始往后交换 swap(2,3)   swap(2,4)...
        //3.上面又产生了新的子数  对于swap(2,3) 的开始 swap(3,4)  swap(3,5)
        //4. 直到没有后续的待交换数字
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <nums.length ; i++) {

            List<Integer> root = new ArrayList<>();
            root.add(nums[i]);

            List<Integer> indexList =new ArrayList<>();
            indexList.add(i);

            permute0(root,0,nums,result,indexList);
        }

        return result;
    }

    private static void permute0(List<Integer> root, int i, int[] nums,List<List<Integer>> result,List<Integer> indexList) {
        i++;

        //从i+1 下标开始

        //没有后续元素了
        if(i==nums.length&& !result.contains(root)){
            result.add(root);
            return;
        }

        // 处理 i+1 和后续的所有的数字
        for (int j = 0; j < nums.length; j++) {
            List<Integer> array = copy(root);
            int temp = nums[j];
            if(check(indexList,j)){
                array.add(temp);
                List<Integer> indexTemp = copy(indexList);
                indexTemp.add(j);
                permute0(array,i,nums,result,indexTemp);
            }
        }

    }

    private static boolean check(List<Integer> indexList,int index) {
        return !indexList.contains(index);
    }

    private static List<Integer> copy(List<Integer> source){
        List<Integer> target = new ArrayList<>(source.size());
        target.addAll(source);
        return target;
    }


    public static void main(String[] args) {
        int[] test = {1,1,3};
        System.out.println(permute(test));
    }


}
