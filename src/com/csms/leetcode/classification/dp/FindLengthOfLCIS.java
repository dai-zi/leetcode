package com.csms.leetcode.classification.dp;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = 1;
        int curLength = 1;
        int end = 1;
        while(end < nums.length){
            if(nums[end] > nums[end-1]){
                curLength++;
            }else{
                max = curLength > max ?curLength : max;
                curLength = 1;
            }
            end ++;
        }
        max = curLength > max ?curLength : max;
        return max;
    }
}
