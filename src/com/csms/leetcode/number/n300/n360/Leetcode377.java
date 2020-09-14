package com.csms.leetcode.number.n300.n360;
//组合总和Ⅳ
//中等
public class Leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 这个值被其它状态参考，设置为 1 是合理的
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    //beibao
    public int combinationSum41(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int[] dp = new int[target + 1];
        //dp[0]表示组成0，一个数都不选就可以了，所以dp[0]=1
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }

        }
        return dp[target];
    }
    public static void main(String[] args) {
    }
}