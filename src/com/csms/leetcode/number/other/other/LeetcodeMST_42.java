package com.csms.leetcode.number.other.other;
//连续子数组的最大和
//简单
public class LeetcodeMST_42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
    }
}