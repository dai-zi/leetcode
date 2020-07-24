package com.csms.leetcode.number.n1300.n1320;
//工作计划的最低难度
//困难
public class Leetcode1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int length = jobDifficulty.length;
        if (length < d)
            return -1;
        //dp[i][j] 表示前 i 天 完成 前 j 项工作的花费的最小难度 i >= j
        int[][] dp = new int[d][length];
        int jobD = 0;
        for (int i = 0; i < jobDifficulty.length; i++) {
            jobD = Math.max(jobD, jobDifficulty[i]);
            dp[0][i] = jobD;
        }
        for(int k = 1;k < d;k++){
            for(int num = k;num < jobDifficulty.length;num++){
                //dp[k][num]
                dp[k][num] = Integer.MAX_VALUE;
                int temp = 0;
                for(int n = num;n >= k;n--){
                    temp = Math.max(temp, jobDifficulty[n]);
                    dp[k][num] = Math.min(dp[k-1][n-1] + temp, dp[k][num]);
                }
            }
        }
        return dp[d-1][jobDifficulty.length-1];
    }
    public static void main(String[] args) {
    }
}