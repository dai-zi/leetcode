package com.csms.leetcode.number.n300.n360;
//猜数字大小II
//中等
public class Leetcode375 {
    public int calculate(int low, int high) {
        if (low >= high)
            return 0;
        int minres = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int res = i + Math.max(calculate(i + 1, high), calculate(low, i - 1));
            minres = Math.min(res, minres);
        }

        return minres;
    }
    public int getMoneyAmount(int n) {
        return calculate(1, n);
    }
//
public int getMoneyAmount1(int n) {
    int[][] dp = new int[n + 1][n + 1];
    for (int len = 2; len <= n; len++) {
        for (int start = 1; start <= n - len + 1; start++) {
            int minres = Integer.MAX_VALUE;
            for (int piv = start; piv < start + len - 1; piv++) {
                int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                minres = Math.min(res, minres);
            }
            dp[start][start + len - 1] = minres;
        }
    }
    return dp[1][n];
}
    public static void main(String[] args) {
    }
}