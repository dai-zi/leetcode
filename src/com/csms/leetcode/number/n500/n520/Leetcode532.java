package com.csms.leetcode.number.n500.n520;

import java.util.Arrays;

//数组中的K_diff数对
//简单
public class Leetcode532 {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Arrays.sort(nums);
        int start = 0, count = 0, prev = 0x7fffffff;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[start] > k || prev == nums[start]) {
                if (++start != i) i--;
            }else if (nums[i] - nums[start] == k) {
                prev = nums[start++];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    }
}