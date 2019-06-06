package com.leetcode.core.array;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 复杂问题分解成小的足够简单的递归解决
 */
public class RainWater {


    public static int trap(int[] height) {

        return cal(array2list(height));
    }

    private static List<List<Integer>> cut(List<Integer> list){
        //去掉最下面一层迭代计算
        List<List<Integer>> result  = new ArrayList<>();

        if(list.isEmpty()){
            return result;
        }
        int maxLevel = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)>maxLevel){
                maxLevel = list.get(i);
            }
        }

        for (int j = 0; j < maxLevel; j++) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <list.size() ; i++) {
                int value = list.get(i);
                if(value>j){
                    temp.add(value-j);
                }else {
                    temp.add(0);
                }
            }
            result.add(temp);
        }
        System.out.println("cut origin = "+list);
        System.out.println("cut result = "+result);

        return result;
    }

    private static List<List<Integer>> split(List<Integer> list,int splitValue){

        List<List<Integer>> result  = new ArrayList<>();//取连续的0的2端的数据
        List<Integer> temp =new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Integer value = list.get(i);
            if(value!=splitValue){


                //1. maybe end : pre is split
                if(i>0 && list.get(i-1)==splitValue&&!temp.isEmpty()){
                    temp.add(value);
                    result.add(temp);
                }

                //2.maybe start: next is split
                if(i+1<list.size()&&list.get(i+1)==splitValue){
                    temp = new ArrayList<>();
                    temp.add(value);
                    //temp.add(splitValue);
                }
                //3.maybe ignore : other

            }else {
                //1.append: if temp is not empty
                if(!temp.isEmpty()){
                    temp.add(splitValue);
                }
                //2. ignore
            }
        }
        System.out.println("split origin "+list);
        System.out.println("split result "+result);
        return result;
    }

    private static int cal(List<Integer> min){
        //split until between range all zero
        int result  =0;
        List<List<Integer>> cut = cut(min);//hang

        for (int i = 0; i < cut.size(); i++) {
            List<Integer> list = cut.get(i);
            List<List<Integer>> split = split(list, 0);
            for (int j = 0; j < split.size(); j++) {
                result+=split.get(j).size()-2;
            }
        }

        return result;

    }



    private static List<Integer> array2list(int[] array){
        List<Integer> list = new ArrayList();
        for (int i = 0; i <array.length ; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public static void main(String[] args) {

        int[] test = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(test));
    }

}
