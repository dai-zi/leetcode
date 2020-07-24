package com.csms.leetcode.number.n100.n140;
//乘积最大子数组
//中等
public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int prevMin = nums[0], prevMax = nums[0], res = nums[0];
        int temp1 = 0, temp2 = 0;
        for (int i = 1; i < nums.length; i++) {
            temp1 = nums[i] * prevMax;
            temp2 = nums[i] * prevMin;
            prevMax = Math.max(Math.max(temp1, temp2), nums[i]);
            prevMin = Math.min(Math.min(temp1, temp2), nums[i]);
            res = Math.max(res, prevMax);
        }
        return res;
    }
    public static void main(String[] args) {
    }
}