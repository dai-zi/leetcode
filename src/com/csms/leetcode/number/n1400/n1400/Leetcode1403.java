package com.csms.leetcode.number.n1400.n1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//非递增顺序的最小子序列
//简单
public class Leetcode1403 {
public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, sum = 0;
        for(int i : nums)
            left += i;
        for(int i = nums.length - 1; i >= 0; i--){
            sum += nums[i];
            left -= nums[i];
            res.add(nums[i]);
            if(sum > left)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}