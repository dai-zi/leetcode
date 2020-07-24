package com.csms.leetcode.number.n1000.n1000;
//合并石头的最低成本
//困难
public class Leetcode1000 {
    private static final int INF = 0x3f3f3f3f;
    private int K;
    private int[] preSum;
    private int[][][] dp;

    public int mergeStones(int[] stones, int K) {
        if (stones.length == 1) {
            return 0;
        } else if (stones.length < K) {
            return -1;
        }

        int n = stones.length;
        this.K = K;
        preSum = new int[n];
        preSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + stones[i];
        }
        dp = new int[n][n][K + 1];

        int res = memoSearch(0, n - 1, 1);
        return res < INF ? res : -1;
    }

    private int sum(int i, int j) {
        return i == 0 ? preSum[j] : preSum[j] - preSum[i - 1];
    }

    private int memoSearch(int i, int j, int k) {
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        if (j - i + 1 == k) {
            return 0;
        } else if (j - i + 1 < k) {
            return INF;
        }
        if (k == 1) {
            dp[i][j][k] = memoSearch(i, j, K) + sum(i, j);
            return dp[i][j][k];
        }

        dp[i][j][k] = INF;
        for (int jj = i; jj < j; jj++) {
            dp[i][j][k] = Math.min(dp[i][j][k],
                    memoSearch(i, jj, 1) + memoSearch(jj + 1, j, k - 1));
        }

        return dp[i][j][k];
    }
    public static void main(String[] args) {
    }
}