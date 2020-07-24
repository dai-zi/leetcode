package com.csms.leetcode.classification.dp;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }
        int max = -2147483647;
        int curSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                if(nums[i] > max){
                    max = nums[i];
                }
                if(curSum + nums[i] > 0){
                    curSum += nums[i];
                }else {
                    curSum = 0;
                }
            }else{
                curSum += nums[i];
                if(curSum > max){
                    max = curSum;
                }
            }
        }
        return max;
    }
}
