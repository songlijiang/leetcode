package com.leetcode.core.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by slj on 2019-01-17
 */
public class TwoSum {


    public static int[] twoSumValue(int[] nums, int target) {

        int [] datas =nums;
        Arrays.sort(nums);
        int length = nums.length;
        int [] result = new int[2];
        int minIndex = 0;
        int maxIndex = length-1;
        for (int i = 0; i <length ; i++) {
            if(minIndex>maxIndex){
                return result;
            }
            if(datas[minIndex]+datas[maxIndex]>target){
                maxIndex--;
            }
            if(datas[minIndex]+datas[maxIndex]<target){
                minIndex++;
            }
            if(datas[minIndex]+datas[maxIndex]==target){
                result[0]=datas[minIndex];
                result[1]=datas[maxIndex];
                break;
            }
        }
        return result;
    }

    public static int[] twoSum(int[] nums ,int target){
        int length =nums.length;
        int [] result = new int[2];
        for (int i = 0; i <length ; i++) {
            for (int j = 0; j <length ; j++) {
                if(i==j){
                    break;
                }
                if(nums[i]+nums[j]==target){
                    result[0]=Math.min(i,j);
                    result[1]=Math.max(i,j);
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> usedIndex = new ArrayList<>();
        int length = nums.length;
        if(length<3){
            return result;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length; j++) {
                for (int k = 0; k <length; k++) {
                    //if(usedIndex.contains(i)||usedIndex.contains(j)||usedIndex.contains(k)){
                    //    continue;
                    //}
                    if(i==j|| j==k || i==k){
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k]==0) {
                        List<Integer> temp = new ArrayList<>(3);
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.sort(Integer::compareTo);
                        if(result.contains(temp)){
                            continue;
                        }
                        result.add(temp);

                        usedIndex.add(i);
                        usedIndex.add(j);
                        usedIndex.add(k);
                    }
                }
            }
        }
        return result;
    }
    public static List<List<Integer>> threeSum2(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        int sentinelIndex = 0;
        int minIndex = 0;
        int maxIndex = length-1;
        for (int i = 0; i < length-2; i++) {
            //reset
            sentinelIndex=i;
            minIndex=sentinelIndex+1;
            maxIndex=length-1;
            boolean find  =false;
            while (minIndex<maxIndex){
                if(nums[sentinelIndex] +nums[minIndex]+nums[maxIndex]<0){
                    minIndex++;
                }
                else if(nums[sentinelIndex] +nums[minIndex]+nums[maxIndex]>0){
                    maxIndex--;
                }
                else if(nums[sentinelIndex] +nums[minIndex]+nums[maxIndex]==0){
                    List<Integer> temp = new ArrayList<>(3);
                    temp.add(nums[sentinelIndex]);
                    temp.add(nums[minIndex]);
                    temp.add(nums[maxIndex]);
                    temp.sort(Integer::compareTo);
                    if(!result.contains(temp)){
                        result.add(temp);
                    }
                    minIndex++;
                    maxIndex--;
                }
            }

        }
        return result;

    }



    public static void main(String[] args) {
        int [] data = {3,2,4};
       // System.out.println(Arrays.toString(TwoSum.twoSumValue(data, 6)));

        int [] data2 = {-2,0,1,1,2};
        System.out.println(TwoSum.threeSum2(data2));
    }
}
