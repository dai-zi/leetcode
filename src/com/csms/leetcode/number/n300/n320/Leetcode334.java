package com.csms.leetcode.number.n300.n320;
//递增的三元子序列
//中等
public class Leetcode334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        for(int num: nums){
            if(num <= min){
                min = num;
            }
            else if(num <= max){
                max = num;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}