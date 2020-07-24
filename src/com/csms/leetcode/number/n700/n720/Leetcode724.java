package com.csms.leetcode.number.n700.n720;
//寻找数组的中心索引
//简单
public class Leetcode724 {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
    }
}