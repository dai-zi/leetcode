package com.csms.leetcode.number.n300.n300;
//区域和检索_数组不可变
//简单
public class Leetcode303 {
    private int[] sum;

    public Leetcode303(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
    public static void main(String[] args) {
    }
}