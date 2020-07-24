package com.csms.leetcode.number.n1400.n1460;

import java.util.Arrays;

//数组中两元素的最大乘积
//简单
public class Leetcode1464 {
	public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }
    public static void main(String[] args) {
    }
}