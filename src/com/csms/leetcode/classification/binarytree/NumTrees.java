package com.csms.leetcode.classification.binarytree;

public class NumTrees {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= i; j++){
                sum += nums[j-1] * nums[i-j];
            }
            nums[i] = sum;
        }
        System.out.println(nums[n]);
        return nums[n];
    }
}
