package com.csms.leetcode.number.other.other;
//消失的数字
//简单
public class LeetcodeMST_17_04 {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;

        return res;
    }

    public static void main(String[] args) {
    }
}