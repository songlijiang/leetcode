package com.leetcode.core;

/**
 * @author songlijiang
 * @version 2019/6/21 16:51
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class MedianSortedArrays {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int [] allSorted = mergeSort(nums1, nums2);
        int middle =allSorted.length/2;
        if(allSorted.length%2==0){
            return  (allSorted[middle]+allSorted[middle-1])/2.0;
        }
        return allSorted[middle];

    }

    private static int[] mergeSort(int[] nums1,int[] nums2){
        int [] result  = new int[nums1.length+nums2.length];
        int index =0;
        int index1 = 0;
        int index2 = 0;
        while (index1<nums1.length && index2<nums2.length){
            int value1 = nums1[index1];
            int value2 = nums2[index2];
            if(value1<=value2){
                index1++;
                result[index] = value1;
            }else {
                index2++;
                result[index]=value2;
            }
            index++;
        }
        if(index1>=nums1.length){
           //copy 2 to end
            System.arraycopy(nums2,index2,result,index,nums2.length-index2);
        }
        if(index2>=nums2.length){
            //copy 1 to end
            System.arraycopy(nums1,index1,result,index,nums1.length-index1);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }

}
