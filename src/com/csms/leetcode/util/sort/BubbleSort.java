package com.csms.leetcode.util.sort;

public class BubbleSort {
    public static void bubbleSort(int[] nums){
        for(int cnt = 0; cnt < nums.length - 1; cnt++){
            for(int i = 1; i < nums.length - cnt; i++){
                if(nums[i] < nums[i - 1]){
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                }
            }
        }


        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,2,3,4,5,33,9,0,4};
        bubbleSort(nums);
    }
}
