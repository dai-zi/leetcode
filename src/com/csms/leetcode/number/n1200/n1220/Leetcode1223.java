package com.csms.leetcode.number.n1200.n1220;

import java.util.Arrays;

//掷骰子模拟
//中等
public class Leetcode1223 {
public int dieSimulator(int n) {
        int[][] dp = new int[n][6];
        // init, roll once, only one sequence end up by every number
        for (int i = 0; i < 6; i++) dp[0][i] = 1;
        // start dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                dp[i][j] = Arrays.stream(dp[i-1]).sum();
            }
        }
        return Arrays.stream(dp[n-1]).sum();
    }

    public static void main(String[] args) {
    }
}