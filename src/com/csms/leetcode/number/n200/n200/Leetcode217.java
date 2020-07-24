package com.csms.leetcode.number.n200.n200;

import java.util.Arrays;

//存在重复元素
//简单
public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}