package com.csms.leetcode.number.n100.n160;
//寻找峰值
//中等
public class Leetcode162 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
    }
}