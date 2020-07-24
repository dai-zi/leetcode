package com.csms.leetcode.number.n500.n560;
//数组拆分I
//简单
public class Leetcode561 {
    int max_sum = Integer.MIN_VALUE;
    public int arrayPairSum(int[] nums) {
        permute(nums, 0);
        return max_sum;
    }
    public void permute(int[] nums, int l) {
        if (l == nums.length - 1) {
            int sum = 0;
            for (int i = 0; i < nums.length / 2; i++) {
                sum += Math.min(nums[i], nums[nums.length / 2 + i]);
            }
            max_sum = Math.max(max_sum, sum);
        }
        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);
            permute(nums, l + 1);
            swap(nums, i, l);
        }
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
    }
}